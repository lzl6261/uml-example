package com.databps.admin.service.impl;

import com.databps.admin.manager.UserManager;
import com.databps.admin.manager.UserMyManager;
import com.databps.admin.service.UserMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author merlin
 * @create 2017-07-21 上午11:14
 */
@Component
public class UserMyServiceImpl implements UserMyService{

  @Autowired
  private UserManager userManager;

  @Autowired
  private UserMyManager userMyManager;

  @Override
  public boolean findAll(String userName) {

    userMyManager.findByUserName(userName);
    userMyManager.findByUserName(userName);

    return false;
  }
}
