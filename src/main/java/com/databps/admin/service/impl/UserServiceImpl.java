package com.databps.admin.service.impl;

import com.databps.admin.dao.UserDao;
import com.databps.admin.domain.User;
import com.databps.admin.service.UserService;
import com.databps.admin.vo.UserVO;
import com.databps.core.mongo.plugin.MongoPage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户实现类
 *
 * @author merlin
 * @create 2017-07-20 下午7:48
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public List<UserVO> listOnPage(MongoPage page) {
    List<UserVO> userVOList = new ArrayList<>();

    List<User> userList = userDao.listOnPage(page);
    for (User user : userList) {
      UserVO userVO = new UserVO();
      userVO.setLevel(user.getLevel());
      userVO.setUname(user.getUname());
      userVOList.add(userVO);
    }

    return userVOList;
  }

  @Override
  public List<UserVO> listByUserName(String username) {
    List<UserVO> userVOList = new ArrayList<>();

    List<User> userList = userDao.listByUserName(username);

    for (User user : userList) {
      UserVO userVO = new UserVO();
      userVO.setLevel(user.getLevel());
      userVO.setUname(user.getUname());
      userVOList.add(userVO);
    }

    return userVOList;
  }

  @Override
  public void update(UserVO userVO) {
    User user = new User();
    user.setLevel(userVO.getLevel());
    user.setUname(userVO.getUname());
    userDao.update(user);

  }

  @Override
  public UserVO findByUserName(String username) {

    User user = userDao.findByUserName(username);

    UserVO userVO = new UserVO();
    userVO.setUname(user.getUname());
    userVO.setLevel(user.getLevel());

    return userVO;
  }

  @Override
  public void deleteByUserName(String username) {
    //一般情况下不会有真删除，只是状态更新
  }

  @Override
  public void insert(UserVO userVO) {
    User user = new User();
    user.setLevel(userVO.getLevel());
    user.setUname(userVO.getUname());
    userDao.insert(user);
  }
}
