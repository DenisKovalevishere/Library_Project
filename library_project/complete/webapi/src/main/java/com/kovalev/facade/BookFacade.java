package com.kovalev.facade;

import java.util.List;

import com.kovalev.dto.book.BookDto;
import com.kovalev.dto.filter.SearchBookFilterDTO;

public interface BookFacade {

    
    BookDto addBook(BookDto bookDTO);
    
    void patchBook(BookDto bookDTO);
    
    BookDto getBook(Long bookId);
    
    List<BookDto> getAllBooks(SearchBookFilterDTO bookFilterDTO);
    
    void removeBook(Long bookId);
}
