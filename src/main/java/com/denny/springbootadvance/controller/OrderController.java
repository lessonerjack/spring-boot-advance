package com.denny.springbootadvance.controller;

import com.denny.springbootadvance.model.OrderMo;
import com.denny.springbootadvance.repository.OrderRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @PostMapping(value = "/order")
    public ResponseEntity<OrderMo> addOrder(@RequestBody OrderMo order){
        log.info("request params:{}",new Gson().toJson(order));
        OrderMo save = orderRepository.save(order);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("status","success");
        return new ResponseEntity<>(save, responseHeader,HttpStatus.OK);
    }
}
