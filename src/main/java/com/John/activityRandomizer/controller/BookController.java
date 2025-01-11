package com.John.activityRandomizer.controller;

import com.John.activityRandomizer.domain.Book;
import com.John.activityRandomizer.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BookController {
  private BookService bookService = new BookService();

  @PostMapping(value = "/book")
  public void addBook(@RequestBody Book book) {
    bookService.addBook(book);
  }

  @GetMapping(value = "/book/{bookId}")
  public Book getBookById(@PathVariable Integer bookId) {
    return bookService.getBook(bookId);
  }

  @GetMapping(value = "/book/all")
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }
}
