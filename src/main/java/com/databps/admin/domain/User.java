package com.databps.admin.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

/**
 * 用户
 *
 * @author merlin
 * @create 2017-07-20 下午7:45
 */
public class User implements Serializable{

  @Id
  private String _id;

  private String uname;

  private String level;

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

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
}
