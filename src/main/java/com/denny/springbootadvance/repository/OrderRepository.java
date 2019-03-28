package com.denny.springbootadvance.repository;

import com.denny.springbootadvance.model.OrderMo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderMo, Long> {
}
