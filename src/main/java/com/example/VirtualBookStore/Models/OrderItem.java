package com.example.VirtualBookStore.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class OrderItem {
    @DBRef
    private Book book;

    private Integer quantity;
    private Double price;

}
