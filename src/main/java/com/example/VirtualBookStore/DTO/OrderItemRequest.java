package com.example.VirtualBookStore.DTO;

import lombok.Data;

@Data
public class OrderItemRequest {
    private String boookId;
    private int quantity;
}
