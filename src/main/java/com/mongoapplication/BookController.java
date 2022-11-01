package com.mongoapplication;

import com.mongoapplication.dao.BookRepository;
import com.mongoapplication.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @PutMapping("/save")
    public Book saveBook(@RequestBody Book book) {
        try {
            return repository.save(book);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
