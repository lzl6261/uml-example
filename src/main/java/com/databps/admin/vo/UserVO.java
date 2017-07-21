package com.databps.admin.vo;


import java.io.Serializable;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author merlin
 * @create 2017-07-21 上午10:41
 */
public class UserVO implements Serializable {

  @NotBlank
  @Size(min = 1, max = 25)
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
}
