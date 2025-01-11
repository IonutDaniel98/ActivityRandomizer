package com.John.activityRandomizer.service;

import com.John.activityRandomizer.domain.Book;
import com.John.activityRandomizer.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  private BookRepository bookRepository;

  public void addBook(Book book) {
    bookRepository.save(book);
  }

  public Book getBook(Integer bookId) {
    return bookRepository.findById(bookId).get();
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
