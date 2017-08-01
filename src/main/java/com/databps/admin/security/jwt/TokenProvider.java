package com.databps.admin.security.jwt;

import io.github.jhipster.config.JHipsterProperties;
import io.jsonwebtoken.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

@Component
public class TokenProvider {

  private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

  private static final String AUTHORITIES_KEY = "auth";

  private String secretKey;

  private long tokenValidityInMilliseconds;

  private long tokenValidityInMillisecondsForRememberMe;

  private final JHipsterProperties jHipsterProperties;

  public TokenProvider(JHipsterProperties jHipsterProperties) {
    this.jHipsterProperties = jHipsterProperties;
  }

  @PostConstruct
  public void init() {
    this.secretKey =
        jHipsterProperties.getSecurity().getAuthentication().getJwt().getSecret();

    this.tokenValidityInMilliseconds =
        1000 * jHipsterProperties.getSecurity().getAuthentication().getJwt()
            .getTokenValidityInSeconds();
    this.tokenValidityInMillisecondsForRememberMe =
        1000 * jHipsterProperties.getSecurity().getAuthentication().getJwt()
            .getTokenValidityInSecondsForRememberMe();
  }

  public String createToken(Authentication authentication, Boolean rememberMe) {
    String authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    long now = (new Date()).getTime();
    Date validity;
    if (rememberMe) {
      validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
    } else {
      validity = new Date(now + this.tokenValidityInMilliseconds);
    }

    return Jwts.builder()
        .setSubject(authentication.getName())
        .claim(AUTHORITIES_KEY, authorities)
        .signWith(SignatureAlgorithm.HS512, secretKey)
        .setExpiration(validity)
        .compact();
  }

  public Authentication getAuthentication(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(token)
        .getBody();

    Collection<? extends GrantedAuthority> authorities =
        Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

    User principal = new User(claims.getSubject(), "", authorities);

    return new UsernamePasswordAuthenticationToken(principal, token, authorities);
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      log.info("Invalid JWT signature.");
      log.trace("Invalid JWT signature trace: {}", e);
    } catch (MalformedJwtException e) {
      log.info("Invalid JWT token.");
      log.trace("Invalid JWT token trace: {}", e);
    } catch (ExpiredJwtException e) {
      log.info("Expired JWT token.");
      log.trace("Expired JWT token trace: {}", e);
    } catch (UnsupportedJwtException e) {
      log.info("Unsupported JWT token.");
      log.trace("Unsupported JWT token trace: {}", e);
    } catch (IllegalArgumentException e) {
      log.info("JWT token compact of handler are invalid.");
      log.trace("JWT token compact of handler are invalid trace: {}", e);
    }
    return false;
  }

  private static final String jwtTokenCookieName = "JWT-TOKEN";

  /**
   * 从cookie获取token
   */
  public String getValue(HttpServletRequest httpServletRequest) {
    Cookie cookie = WebUtils.getCookie(httpServletRequest, jwtTokenCookieName);
    return cookie != null ? cookie.getValue() : null;
  }

  /**
   * 创建cookie
   * @param httpServletResponse
   * @param value
   * @param secure
   * @param maxAge
   * @param domain
   */
  public void create(HttpServletResponse httpServletResponse,String value,
      Boolean secure, Integer maxAge, String domain) {
    Cookie cookie = new Cookie(jwtTokenCookieName, value);
    cookie.setSecure(secure);
    cookie.setHttpOnly(true);
    cookie.setMaxAge(maxAge);
    cookie.setDomain(domain);
    cookie.setPath("/");
    httpServletResponse.addCookie(cookie);
  }
}
