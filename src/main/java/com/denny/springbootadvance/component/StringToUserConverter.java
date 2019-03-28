package com.denny.springbootadvance.component;

import com.denny.springbootadvance.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @user denny.wang
 * Date: 2019/3/25 0025
 */
@Component
public class StringToUserConverter implements Converter<String,User> {

  @Override
  public User convert(String s) {
   User user = new User();
    String[] strings = s.split("-");
    String name = strings[0];
    String age = strings[1];
    user.setName(name);
    user.setAge(age);
    return user;
  }
}
