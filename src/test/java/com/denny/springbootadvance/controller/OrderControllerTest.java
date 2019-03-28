package com.denny.springbootadvance.controller;

import com.denny.springbootadvance.model.OrderMo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
public class OrderControllerTest {

    @Test
    public void testAddOrder(){
        RestTemplate template = new RestTemplate();
        OrderMo mo = new OrderMo();
        mo.setOrigin("外部");
        mo.setAmount(new BigDecimal("89789"));
        mo.setOrderName("测试");
        mo.setCreateTime(new Date());
        ResponseEntity<OrderMo> orderMoResponseEntity = template.postForEntity("http://localhost:8080/order", mo, OrderMo.class);
        HttpStatus statusCode = orderMoResponseEntity.getStatusCode();
        log.info("httpStatus:{}",statusCode.value());
        HttpHeaders headers = orderMoResponseEntity.getHeaders();
        log.info(headers.get("status").toString());
        OrderMo body = orderMoResponseEntity.getBody();
        log.info("add order:{}",new Gson().toJson(body));
    }
}
