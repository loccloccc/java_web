package org.example.ecommerce.model;

import lombok.Data;

@Data
public class CartItem {
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
}