package com.leviethoang.stockservice.repository;

import com.leviethoang.stockservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
