package com.databps.admin.dao;

import com.databps.admin.domain.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户
 *
 * @author merlin
 * @create 2017-07-20 下午7:49
 */
@Repository
public interface UserDao extends MongoRepository<User,String> {

  Optional<User> findOneByUserName(String userName);


}
