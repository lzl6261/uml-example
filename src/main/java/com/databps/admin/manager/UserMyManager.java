package com.databps.admin.manager;

import com.databps.admin.dao.UserDao;
import com.databps.admin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author merlin
 * @create 2017-07-21 上午11:11
 */
public class UserMyManager {

  @Autowired
  private UserDao userDao;

  public User findByUserName(String userName){
    return userDao.findByUserName(userName);
  }

}
