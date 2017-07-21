package com.databps.admin.dao;

import com.databps.admin.domain.User;
import com.databps.core.mongo.plugin.MongoPage;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * 用户
 *
 * @author merlin
 * @create 2017-07-20 下午7:49
 */
@Repository
public class UserDao {

  @Autowired
  private MongoTemplate mongoTemplate;

  private String collectionName = "user";

  public User findByUserName(String username) {
    Query query = new Query();
    query.addCriteria(Criteria.where("uname").is(username));
    User user = mongoTemplate.findOne(query, User.class, collectionName);
    return user;
  }


  public List<User> listOnPage(MongoPage page) {
    Query query = new Query();

    long count = mongoTemplate.count(query, collectionName);
    page.setTotalResults(count);
    Sort sort = new Sort(Direction.DESC, "level");
    query.with(sort).skip(page.getFirstResult()).limit(page.getMaxResults());
    List<User> userList = mongoTemplate.find(query, User.class, collectionName);

    return userList;
  }

  public List<User> listByUserName(String username) {

    Query query = new Query();

    query.addCriteria(Criteria.where("uname").is(new ObjectId(username)));
    List<User> userList = mongoTemplate.find(query, User.class, collectionName);

    return userList;
  }

  public void insert(User user) {

    mongoTemplate.insert(user, collectionName);

  }

  public void updateByUserId(User user, String userId) {
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(new ObjectId(userId)));
    Update update = new Update();
    update.set("username", user.getUname()).set("level", "1");
    mongoTemplate.updateFirst(query, update, collectionName);
  }


  public void update(User user) {
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(new ObjectId(user.get_id())));
    Update update = new Update();
    update.set("username", user.getUname());
    mongoTemplate.updateFirst(query, update, collectionName);
  }

}
