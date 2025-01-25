package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
