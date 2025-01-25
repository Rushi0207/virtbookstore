package com.example.VirtualBookStore.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "user")
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String address;

}
