package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Book findById(long id);
    List<Book> findByGenre(String genre);

    Book findByTitle(String title);
}
