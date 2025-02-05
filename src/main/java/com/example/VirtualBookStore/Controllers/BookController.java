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

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        Book book1 = bookService.findbyId(book.getId());
        if(book1 == null){
            return new ResponseEntity<>("book is not present", HttpStatus.BAD_REQUEST);
        }

        if(!book.getTitle().isEmpty() || !book.getTitle().isBlank() || book.getTitle() != null)
            book1.setTitle(book.getTitle());

        if(book.getAuthor() != null || book.getAuthor().isBlank() || book.getAuthor().isEmpty())
            book1.setAuthor(book.getAuthor());
        if(book.getGenre() != null || book.getGenre().isEmpty() || book.getGenre().isBlank())
            book1.setGenre(book.getGenre());
        if(book.getPrice() != null)
            book1.setPrice(book.getPrice());
        if(book.getDescription() != null || book.getDescription().isBlank() || book.getDescription().isEmpty())
            book1.setDescription(book.getDescription());
        if(book.getStock() != null)
            book1.setStock(book.getStock());
        if(book.getCoverImage() != null || !book.getCoverImage().isEmpty() || !book.getCoverImage().isBlank())
            book1.setCoverImage(book.getCoverImage());

        if(bookService.update(book1))
            return new ResponseEntity<>(book1+"book updates succesfully", HttpStatus.OK );

        return new ResponseEntity<>("Unable to udate the book" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Book> getSingleBook(@PathVariable Long id){
        Book book = bookService.findbyId(id);
        if(book == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    private ResponseEntity<List<Book>> getBooksByGenere(@PathVariable String genre){

        List<Book> books = bookService.findByGenre(genre);
        if(books == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    private ResponseEntity<Book> findBookbyTitle(@PathVariable String title){
        Book book = bookService.findBookByTitle(title);
        if(book != null)
            return new ResponseEntity<>(book,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
 }