package com.leviethoang.stockservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    private Long id;
    private Long productId;
    private String skuCode;
    private Integer quantity;
}
