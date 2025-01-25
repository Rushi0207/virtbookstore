package com.example.VirtualBookStore.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CartItem {
    @DBRef
    private Book book;
    private Integer quantity;

}
