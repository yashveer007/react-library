package com.example.library.controller;

import com.example.library.entities.Book;
import com.example.library.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * method to get the book on the basis of bookId
     * @param bookId
     * @return
     */
    @GetMapping("get/{bookId}")
    public ResponseEntity<Book> findBookById(@PathVariable("bookId") int bookId){
        log.info("Inside findBookById() method : ", bookId);
        Book book = bookService.getBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    /**
     * method to fetch all book from the db
     * @return
     */
    @GetMapping("/find/all")
    public ResponseEntity<List<Book>> getListOfBook(){
        List<Book> allBook = bookService.getAllBook();
        return new ResponseEntity<>(allBook, HttpStatus.OK);
    }

    /**
     * method to add book in the DB
     * @param book
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book addedBook = bookService.addBook(book);
        return new ResponseEntity<>(addedBook,HttpStatus.OK);
    }

    /**
     * method to delete book on the basis of bookId
     * @param book
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestBody Book book){
        String success = bookService.deleteBookById(book.getBookId());
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

}
