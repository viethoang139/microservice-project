package com.leviethoang.productservice.controller;

import com.leviethoang.productservice.dto.ProductDto;
import com.leviethoang.productservice.exception.ResourceNotFoundException;
import com.leviethoang.productservice.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl service;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(service.createProduct(productDto) , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId){
        return ResponseEntity.ok(service.getProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable("id") Long productId , @RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(service.updateProductById(productDto,productId));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long productId){
        service.deleteProductById(productId);
        return ResponseEntity.ok("Delete successfully!!!");
    }

}
