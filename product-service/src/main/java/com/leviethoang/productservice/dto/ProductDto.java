package com.leviethoang.productservice.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NotBlank(message = "productName should not be blank")
    private String productName;
    @NotBlank(message = "productDescription should not be blank")
    private String productDescription;
    @NotNull(message = "price should not be null")
    @DecimalMin(value = "0.0" ,inclusive = false,message = "Price must be greater than 0.0")
    private Double price;
}
