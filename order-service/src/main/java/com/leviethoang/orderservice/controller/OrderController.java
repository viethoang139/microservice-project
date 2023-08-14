package com.leviethoang.orderservice.controller;

import com.leviethoang.orderservice.dto.ApiResponse;
import com.leviethoang.orderservice.dto.OrderDto;
import com.leviethoang.orderservice.producer.OrderProducer;
import com.leviethoang.orderservice.service.impl.OrderServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderServiceImpl service;
    private final OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody @Valid OrderDto orderDto){
        service.createOrder(orderDto);
        orderProducer.sendMessage(orderDto);
        return new ResponseEntity<>("Order successfully" , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable("id")Long productId){
        return ResponseEntity.ok(service.getOrderById(productId));
    }

}
