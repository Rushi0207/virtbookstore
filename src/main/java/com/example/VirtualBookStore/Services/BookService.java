package com.example.VirtualBookStore.Services;

import com.example.VirtualBookStore.Models.Book;
import com.example.VirtualBookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        try{
            return bookRepository.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Book newBook(Book book) {
        try{
            bookRepository.save(book);
            return book;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Book findbyId(long id) {
        return bookRepository.findById(id);
    }

    public boolean update(Book book) {
        try{
            bookRepository.save(book);
            return true;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Book> findByGenre(String genre) {
        try{
            return  bookRepository.findByGenre(genre);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Book findBookByTitle(String title) {
        try{
            return bookRepository.findByTitle(title);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
