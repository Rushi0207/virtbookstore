package com.example.VirtualBookStore.DTO;

import lombok.*;

import java.util.List;

@Data
public class OrderRequest {

    private String userId;
    private List<OrderItemRequest> items;
}
