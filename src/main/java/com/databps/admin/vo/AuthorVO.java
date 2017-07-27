package com.databps.admin.vo;

import com.databps.admin.domain.Author;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author merlin
 * @create 2017-07-26 上午1:16
 */
public class AuthorVO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  @NotNull
  @Size(min = 1, max = 20)
  private String name;

  private LocalDate birthDate;

  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }


  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }

}
