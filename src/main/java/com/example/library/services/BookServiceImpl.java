package com.example.library.services;

import com.example.library.dao.BookDao;
import com.example.library.entities.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.SomethingWentWrongException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao dao;

    /**
     * Adding Book to DB
     * @param book
     * @return
     */
    @Override
    public Book addBook(Book book) {
        try{
            Book save = dao.save(book);
            return save;
        }catch (Exception ex){
            throw new SomethingWentWrongException("Failed to Save In DB, try it again");
        }
    }

    /**
     * fetching all books from the DB
     * @return
     */
    @Override
    public List<Book> getAllBook() {
        try{
            List<Book> boolList = dao.findAll();
            if(boolList.size() >0){
                return boolList;
            }
            throw new BookNotFoundException("No Book Found in DB");
        }catch (Exception ex){
            throw new SomethingWentWrongException("Exception Occured while fetching data from DB");
        }
    }

    /**
     * Fetching book from the db on the basis of bookId
     * @param bookId
     * @return
     */
    @Override
    public Book getBookById(int bookId) {
        return null;
    }

    /**
     * deleting book
     * @param bookId
     * @return
     */
    @Override
    public Book deleteBookById(int bookId) {
        return null;
    }
}
