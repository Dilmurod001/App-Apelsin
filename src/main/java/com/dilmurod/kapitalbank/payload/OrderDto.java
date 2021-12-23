package com.dilmurod.kapitalbank.payload;

import lombok.Data;

@Data
public class OrderDto {
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
}
