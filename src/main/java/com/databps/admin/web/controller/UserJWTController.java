package com.databps.admin.web.controller;


import com.databps.admin.security.UserNotActivatedException;
import com.databps.admin.security.jwt.TokenProvider;
import com.databps.admin.web.controller.vm.LoginVM;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to authenticate users.
 */
@Controller
@RequestMapping("/api")
public class UserJWTController {

  private final Logger log = LoggerFactory.getLogger(UserJWTController.class);

  private final TokenProvider tokenProvider;

  private final AuthenticationManager authenticationManager;

  public UserJWTController(TokenProvider tokenProvider,
      AuthenticationManager authenticationManager) {
    this.tokenProvider = tokenProvider;
    this.authenticationManager = authenticationManager;
  }

  @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
  public String getLoginPage(Model model) {
    return "login/authenticate";
  }

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public String authorize(@Valid LoginVM loginVM, HttpServletResponse response,
      RedirectAttributes attr) {

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword());

    try {
      Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
      SecurityContextHolder.getContext().setAuthentication(authentication);
      boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();
      String jwt = tokenProvider.createToken(authentication, rememberMe);
      tokenProvider.create(response, jwt, false, -1, "localhost");
    } catch (AuthenticationException ae) {
      log.debug("Authentication exception trace: {}", ae);

      attr.addFlashAttribute("error", ae.getMessage());
    }
    return "redirect:authenticate";
  }


}
