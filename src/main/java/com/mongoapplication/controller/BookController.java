package com.mongoapplication.controller;

import com.mongoapplication.entity.Book;
import com.mongoapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PutMapping("/save")
    public Book saveBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return service.findAllBooks();
    }
}
