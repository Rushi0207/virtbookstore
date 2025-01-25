package com.example.VirtualBookStore.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Payment {
    @Id
    private String id;

    @DBRef
    private Order order;

    private String paymentMethod;
    private String paymentStatus;
    private String transactionId;
    private String timestamp;


}
