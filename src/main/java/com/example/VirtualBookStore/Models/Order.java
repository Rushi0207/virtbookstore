package com.example.VirtualBookStore.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Order {
    @Id
    private String id;

    @DBRef
    private User user;

    private List<OrderItem> orderItems;
    private Double item;
    private Double totalAmount;
    private String status;
    private String createdAt;

}
