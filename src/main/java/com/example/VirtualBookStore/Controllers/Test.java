package com.example.VirtualBookStore.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping
    private String test(){
        return "test succesfull";
    }
}
