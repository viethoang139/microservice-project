package com.leviethoang.orderservice.service.impl;

import com.leviethoang.orderservice.dto.ApiResponse;
import com.leviethoang.orderservice.dto.OrderDto;
import com.leviethoang.orderservice.dto.ProductDto;
import com.leviethoang.orderservice.entity.Order;
import com.leviethoang.orderservice.repository.OrderRepository;
import com.leviethoang.orderservice.service.APIClient;
import com.leviethoang.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
   private final OrderRepository orderRepository;
   private final ModelMapper modelMapper;
   private final APIClient apiClient;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        ProductDto productDto = apiClient.getProductById(orderDto.getProductId());
        Order order = modelMapper.map(orderDto , Order.class);
        Order savedOrder = orderRepository.save(order);
        OrderDto savedOrderDto = modelMapper.map(savedOrder , OrderDto.class);
        return savedOrderDto;
    }

    @CircuitBreaker(name ="${spring.application.name}" , fallbackMethod = "defaultResponse")
    @Override
    public ApiResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).get();

        ProductDto productDto = apiClient.getProductById(order.getProductId());

        OrderDto orderDto = modelMapper.map(order,OrderDto.class);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setOrder(orderDto);
        apiResponse.setProduct(productDto);
        return apiResponse;
    }

    public ApiResponse defaultResponse(Long id , Exception exception) {
        Order order = orderRepository.findById(id).get();

        ProductDto productDto = new ProductDto();
        productDto.setProductName("Default product name");
        productDto.setProductDescription("Default product description default");
        productDto.setPrice(0.0);

        OrderDto orderDto = modelMapper.map(order,OrderDto.class);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setOrder(orderDto);
        apiResponse.setProduct(productDto);
        return apiResponse;
    }




}
