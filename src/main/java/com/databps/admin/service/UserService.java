package com.databps.admin.service;

import com.databps.admin.domain.User;
import com.databps.admin.vo.UserVO;
import com.databps.core.mongo.plugin.MongoPage;
import java.util.List;

/**
 * 用户
 *
 * @author merlin
 * @create 2017-07-20 下午7:44
 */
public interface UserService {

  List<UserVO> listOnPage(MongoPage page);

  List<UserVO> listByUserName(String username);

  void update(UserVO userVO);

  UserVO findByUserName(String username);

  void deleteByUserName(String username);

  void insert(UserVO userVO);

}
