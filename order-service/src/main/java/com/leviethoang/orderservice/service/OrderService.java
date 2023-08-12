package com.leviethoang.orderservice.service;

import com.leviethoang.orderservice.dto.ApiResponse;
import com.leviethoang.orderservice.dto.OrderDto;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    ApiResponse getOrderById(Long id);

}
