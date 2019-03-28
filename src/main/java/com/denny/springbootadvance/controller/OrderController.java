package com.denny.springbootadvance.controller;

import com.denny.springbootadvance.exception.NotFoundException;
import com.denny.springbootadvance.model.OrderMo;
import com.denny.springbootadvance.repository.OrderRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping(value = "/order")
    public ResponseEntity<OrderMo> addOrder(@RequestBody OrderMo order) {
        log.info("request params:{}", new Gson().toJson(order));
        OrderMo save = orderRepository.save(order);
        String success = save != null ? "true" : "false";
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("success", success);
        return new ResponseEntity<>(save, responseHeader, HttpStatus.OK);
    }
    @GetMapping(value = "/order/{orderName}/{origin}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderMo> getOrder(@PathVariable String orderName,@PathVariable String origin){
        try {
            log.info("request params:{}",orderName);
            List<OrderMo> order = orderRepository.findByOrderNameAndOrigin(orderName,origin);
            log.info("order");
            if (order == null || order.size() == 0){
                throw new NotFoundException(1L,"找不到订单【"+orderName+"】信息");
            }
            return order;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new NotFoundException(1L,"找不到订单【"+orderName+"】信息");
        }
    }
}
