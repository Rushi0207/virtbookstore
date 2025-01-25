package com.example.VirtualBookStore.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {

    @Id
    private long id;
    private String title;
    private String author;
    private String genre;
    private Long price;
    private String description;
    private Long stock;
    private String coverImage;
    private Double averageRating;

}
