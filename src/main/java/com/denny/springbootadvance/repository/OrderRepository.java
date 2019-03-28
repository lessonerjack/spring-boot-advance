package com.denny.springbootadvance.repository;

import com.denny.springbootadvance.model.OrderMo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderMo, Long> {


    List<OrderMo> findByOrderNameAndOrigin(String orderName, String origin);
}
