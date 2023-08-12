package com.leviethoang.productservice.service.impl;

import com.leviethoang.productservice.dto.ProductDto;
import com.leviethoang.productservice.entity.Product;
import com.leviethoang.productservice.exception.ResourceNotFoundException;
import com.leviethoang.productservice.repository.ProductRepository;
import com.leviethoang.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);

        Product savedProduct = productRepository.save(product);

        ProductDto savedProductDto = modelMapper.map(savedProduct,ProductDto.class);

        return savedProductDto;

    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","ID",id));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProductById(ProductDto productDto, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","ID",id));
        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setPrice(productDto.getPrice());
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","ID",id));
        productRepository.deleteById(id);
    }
}
