package com.John.activityRandomizer.service;

import com.John.activityRandomizer.domain.Book;
import com.John.activityRandomizer.repository.BookRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {
  @Autowired private BookRepository bookRepository;

  public void addBook(Book book) {
    log.debug("Requested to save the book: {}", book);
    bookRepository.save(book);
  }

  public Book getBook(Long bookId) {
    log.debug("Requested to retrieve the book with id: {}", bookId);
    return bookRepository.findById(bookId).get();
  }

  public List<Book> getAllBooks() {
    log.debug("Requested to retrieve all the books");
    return bookRepository.findAll();
  }

  public void updateBook(Long bookId, Book book) {
    log.debug("Requested to update the book {} with {}", bookId, book);
    book.setId(bookId);
    bookRepository.save(book);
  }

  public void deleteBook(Long bookId) {
    log.debug("Requested to delete the book with id: {}", bookId);
    bookRepository.deleteById(bookId);
  }

  private Boolean bookExists(Long id) {
    return bookRepository.existsById(id);
  }
}
