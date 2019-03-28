package com.denny.springbootadvance.controller;

import com.denny.springbootadvance.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Description:
 *
 * @user denny.wang
 * Date: 2019/3/18 0018
 */
@RestController
@Slf4j
public class HelloController {
  @GetMapping("/hello")
  public String getHello(){
    return "Hello World";
  }

  @RequestMapping(value = "/user",method = RequestMethod.POST)
  public User postUser(@RequestBody User user) throws JsonProcessingException {
/*    User user = new User("王","18");*/
    log.info("request params:{}",new ObjectMapper().writeValueAsString(user));
    return user;
  }
  @GetMapping("/GetUser")
  public User GetUser( User user){
    return user;
  }
  @GetMapping("/intercept")
  public String GetIntercept( ){
    return "Interceptor";
  }
}
