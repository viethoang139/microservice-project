package com.leviethoang.orderservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    private Long id;
    @Min(value = 1)
    private Long productId;
    @NotEmpty(message = "skuCode should not be null or empty")
    private String skuCode;
    @Min(value = 1)
    @Max(value = 10)
    private Integer quantity;
}
