package com.denny.springbootadvance.controller;

import com.denny.springbootadvance.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Description:
 *
 * @user denny.wang
 * Date: 2019/3/18 0018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HelloControllerTest {

  private MockMvc mockMvc;

  @Before
  public void setUp(){
    mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
  }
  @Test
  public void getHello() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Hello World")));

  }

  @Test
  public void postUser() throws Exception {

    User user = new User();
    user.setAge("18");
    user.setName("hhh");
    ObjectMapper mapper = new ObjectMapper();
    String s = mapper.writeValueAsString(user);
    System.out.println(s);
    ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.post("/user").accept(MediaType.APPLICATION_JSON)
            .content(s));
            perform.andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("王"))
            .andExpect(jsonPath("$.age").value("18"));
  }
  @Test
  public void post() throws JsonProcessingException {

    RestTemplate template = new RestTemplate();
    User user = new User();
    user.setAge("18");
    user.setName("hhh");
    User user1 = template.postForObject("http://localhost:8080/user", user, User.class);
    System.out.println(new ObjectMapper().writeValueAsString(user1));

  }
}
