package com.John.activityRandomizer.controller;

import com.John.activityRandomizer.domain.Book;
import com.John.activityRandomizer.repository.BookRepository;
import com.John.activityRandomizer.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
  @Autowired private BookRepository bookRepository;
  @Autowired private BookService bookService;

  @PostMapping(value = "/book")
  public ResponseEntity addBook(@RequestBody Book book) {
    bookService.addBook(book);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/book/{bookId}")
  public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
    return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
  }

  @GetMapping(value = "/book/all")
  public ResponseEntity<List<Book>> getAllBooks() {
    return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
  }

  @PutMapping(value = "/book/{bookId}")
  public ResponseEntity updateBook(@PathVariable Long bookId, @RequestBody Book book) {
    bookService.updateBook(bookId, book);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/book/{bookId}")
  public ResponseEntity deleteBook(@PathVariable Long bookId) {
    bookService.deleteBook(bookId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
