package com.leviethoang.productservice.service;

import com.leviethoang.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto updateProductById(ProductDto productDto , Long id);

    void deleteProductById(Long id);

}
