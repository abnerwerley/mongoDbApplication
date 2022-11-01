package com.mongoapplication.service;

import com.mongoapplication.dao.BookRepository;
import com.mongoapplication.entity.Book;
import com.mongoapplication.exception.RequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService service;

    @Mock
    private BookRepository repository;

    public static final int ID = 1;
    public static final String AUTHOR_NAME = "Author Name";
    public static final String NAME = "Name";

    @Test
    void testSaveBook() {
        doReturn(getBook()).when(repository).save(getBook());
        Book savingBook = service.saveBook(getBook());
        assertEquals(savingBook, getBook());
        verify(repository).save(getBook());
    }

    @Test
    void testSaveBookException(){
        doThrow(RequestException.class).when(repository).save(getBook());
        Exception exception = assertThrows(Exception.class, () -> service.saveBook(getBook()));
        assertEquals("Error saving book.", exception.getMessage());
    }

    @Test
    void testFindAllBooks(){
        doReturn(getBookList()).when(repository).findAll();
        List<Book> list = service.findAllBooks();
        assertNotNull(list);
    }

    @Test
    void testFindAllBooksException(){
        doThrow(RequestException.class).when(repository).findAll();
        Exception exception = assertThrows(Exception.class, () -> service.findAllBooks());
        assertEquals("Error finding all books.", exception.getMessage());
    }

    private Book getBook() {
        return Book.builder()
                .id(ID)
                .authorName(AUTHOR_NAME)
                .name(NAME)
                .build();
    }

    private List<Book> getBookList() {
        return List.of(Book.builder()
                .id(ID)
                .authorName(AUTHOR_NAME)
                .name(NAME)
                .build());
    }
}
