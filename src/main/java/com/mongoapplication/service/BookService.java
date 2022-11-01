package com.mongoapplication.service;

import com.mongoapplication.dao.BookRepository;
import com.mongoapplication.entity.Book;
import com.mongoapplication.exception.RequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book saveBook(Book book) {
        try {
            return repository.save(book);
        } catch (Exception e) {
            log.error("Error saving book.");
            e.printStackTrace();
            throw new RequestException(HttpStatus.BAD_REQUEST, "Error saving book.");
        }
    }

    public List<Book> findAllBooks() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error("Error finding all books.");
            e.printStackTrace();
            throw new RequestException(HttpStatus.BAD_REQUEST, "Error finding all books.");
        }
    }
}
