package com.example.library.services;

import com.example.library.entities.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    List<Book> getAllBook();

    Book getBookById(int bookId);

    String deleteBookById(int bookId);

}
