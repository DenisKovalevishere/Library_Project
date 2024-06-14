package com.kovalev.service;

import java.util.List;
import java.util.Optional;

import com.kovalev.domain.book.Book;
import com.kovalev.dto.SearchBookFilter;
import com.kovalev.exception.AlreadyExistsException;

public interface BookService {

    Optional<Book> getBookById(Long id);
    
    Optional<Book> createBook(Book book) throws AlreadyExistsException;
    
    void saveBook(Book book);
    
    void removeBookById(Long id);
    
    List<Book> findAllBooksBySort(SearchBookFilter filter) throws Exception;
    
    Optional<Book> getBookByName(String name);
}
