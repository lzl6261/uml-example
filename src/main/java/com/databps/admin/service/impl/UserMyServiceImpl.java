package com.databps.admin.service.impl;

import com.databps.admin.dao.UserDao;
import com.databps.admin.domain.User;
import com.databps.admin.manager.UserManager;
import com.databps.admin.manager.UserMyManager;
import com.databps.admin.service.UserMyService;
import com.databps.admin.service.UserService;
import com.databps.admin.vo.UserVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author merlin
 * @create 2017-07-21 上午11:14
 */
@Component
@Deprecated
public class UserMyServiceImpl implements UserMyService{

  @Autowired
  private UserManager userManager;

  @Autowired
  private UserMyManager userMyManager;

  @Override
  public boolean findAll(String userName) {

//    userMyManager.findByUserName(userName);
//    userMyManager.findByUserName(userName);

    return false;
  }

  /**
   * 用户实现类
   *
   * @author merlin
   * @create 2017-07-20 下午7:48
   */
//  @Service
//  public static class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public List<UserVO> listOnPage(Pageable pageable) {
//      List<UserVO> userVOList = new ArrayList<>();
//
//
//      Page<User> userList =userDao.findAll(pageable);
//      for (User user : userList) {
//        UserVO userVO = new UserVO();
//        userVO.setLevel(user.getLevel());
//        userVO.setUname(user.getUserName());
//        userVOList.add(userVO);
//      }
//
//      return userVOList;
//    }
//
//    @Override
//    public List<UserVO> listByUserName(String username) {
//      List<UserVO> userVOList = new ArrayList<>();
//
//  //
//  //    List<User> userList = userDao.findOneByUserName(username);
//  //
//  //    for (User user : userList) {
//  //      UserVO userVO = new UserVO();
//  //      userVO.setLevel(user.getLevel());
//  //      userVO.setUname(user.getUname());
//  //      userVOList.add(userVO);
//  //    }
//
//      return userVOList;
//    }
//
//    @Override
//    public void update(UserVO userVO) {
//      User user = new User();
//      user.setLevel(userVO.getLevel());
//      user.setUserName(userVO.getUname());
//      //userDao.update(user);
//
//    }
//
//    @Override
//    public UserVO findByUserName(String username) {
//
//      Optional<User> user = userDao.findOneByUserName(username);
//
//      UserVO userVO = new UserVO();
//
//      userVO.setUname( user.get().getUserName());
//      userVO.setLevel( user.get().getLevel());
//
//      return userVO;
//    }
//
//    @Override
//    public void deleteByUserName(String username) {
//      //一般情况下不会有真删除，只是状态更新
//    }
//
//    @Override
//    public void insert(UserVO userVO) {
//      User user = new User();
//      user.setLevel(userVO.getLevel());
//      user.setUserName(userVO.getUname());
//      userDao.insert(user);
//    }
//  }
}
