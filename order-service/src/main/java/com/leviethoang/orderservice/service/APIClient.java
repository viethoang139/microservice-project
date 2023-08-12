package com.leviethoang.orderservice.service;

import com.leviethoang.orderservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "PRODUCT-SERVICE")
public interface APIClient {
    @GetMapping("api/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId);
}
