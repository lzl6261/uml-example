package com.databps.admin.service.impl;

import com.databps.admin.domain.Admin;
import com.databps.admin.domain.Authority;
import com.databps.admin.repository.AuthorityRepository;
import com.databps.admin.repository.UserRepository;
import com.databps.admin.security.AuthoritiesConstants;
import com.databps.admin.service.UserService;
import com.databps.admin.service.util.RandomUtil;
import com.databps.admin.vo.UserVO;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author merlin
 * @create 2017-07-31 下午8:04
 */
@Service
public class UserServiceImpl implements UserService {

  private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthorityRepository authorityRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public List<UserVO> listOnPage(Pageable pageable) {
    return null;
  }

  @Override
  public List<UserVO> listByUserName(String username) {
    return null;
  }

  @Override
  public void update(UserVO userVO) {

  }

  @Override
  public UserVO findByUserName(String username) {
    return null;
  }

  @Override
  public void deleteByUserName(String username) {

  }

  @Override
  public void insert(UserVO userVO) {

  }

  @Override
  public Optional<Admin> findOneByLogin(String login) {
    return userRepository.findOneByLogin(login);
  }

  @Override
  public Admin createUser(String login, String password, String firstName, String lastName,
      String email,
      String imageUrl, String langKey) {

    Admin newUser = new Admin();
    Authority authority = new Authority();
    authority.setName(AuthoritiesConstants.ADMIN);
    Set<Authority> authorities = new HashSet<>();
    String encryptedPassword = passwordEncoder.encode(password);
    newUser.setLogin(login);
    // new user gets initially a generated password
    newUser.setPassword(encryptedPassword);
    newUser.setFirstName(firstName);
    newUser.setLastName(lastName);
    newUser.setEmail(email);
    newUser.setImageUrl(imageUrl);
    newUser.setLangKey(langKey);
    // new user is not active
    newUser.setActivated(false);
    // new user gets registration key
    newUser.setActivationKey(RandomUtil.generateActivationKey());
    authorities.add(authority);
    newUser.setAuthorities(authorities);
    userRepository.save(newUser);
    log.debug("Created Information for User: {}", newUser);
    return newUser;
  }
}
