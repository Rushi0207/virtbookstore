package com.example.VirtualBookStore.Controllers;

import com.example.VirtualBookStore.Models.Book;
import com.example.VirtualBookStore.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){

        List<Book> book = bookService.getBooks();

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> newBook(@RequestBody Book book){
        Book book1 = bookService.newBook(book);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }
}
