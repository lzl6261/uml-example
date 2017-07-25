package com.databps.admin.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 用户
 *
 * @author merlin
 * @create 2017-07-20 下午7:45
 */
public class User implements Serializable{

  @Id
  private String _id;

  @Field("user_name")
  private String userName;

  private String level;


  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
