package com.example.VirtualBookStore.Models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "review")
public class Review {

    @Id
    private String id;

    @DBRef
    private User user;

    @DBRef
    private Book book;

    private String comment;
    private Double rating;
    private String timeStamp;

}
