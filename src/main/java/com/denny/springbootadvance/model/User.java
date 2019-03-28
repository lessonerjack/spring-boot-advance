package com.denny.springbootadvance.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @user denny.wang
 * Date: 2019/3/18 0018
 */
public class User implements Serializable{
  private String name;
  @NotNull(message = "年龄不能为空")
  private String age;
  @Past
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }


}
