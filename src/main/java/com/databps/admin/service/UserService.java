package com.databps.admin.service;

import com.databps.admin.domain.User;
import com.databps.admin.vo.UserVO;
import com.databps.core.mongo.plugin.MongoPage;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 用户
 *
 * @author merlin
 * @create 2017-07-20 下午7:44
 */
public interface UserService {

  List<UserVO> listOnPage(Pageable pageable);

  List<UserVO> listByUserName(String username);

  void update(UserVO userVO);

  UserVO findByUserName(String username);

  void deleteByUserName(String username);

  void insert(UserVO userVO);

}
