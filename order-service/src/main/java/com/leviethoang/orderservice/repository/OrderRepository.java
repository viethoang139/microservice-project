package com.leviethoang.orderservice.repository;

import com.leviethoang.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {
}
