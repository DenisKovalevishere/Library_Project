package com.kovalev.facade.imp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kovalev.domain.book.Book;
import com.kovalev.dto.book.BookDto;
import com.kovalev.dto.filter.SearchBookFilterDTO;
import com.kovalev.exceptions.CreatingException;
import com.kovalev.facade.BookFacade;
import com.kovalev.mappers.BookMapper;
import com.kovalev.mappers.SearchBookFilterMapper;
import com.kovalev.service.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookFacadeImp implements BookFacade{

    private BookService bookService;
    private BookMapper bookMapper;
    private SearchBookFilterMapper searchBookFilterMapper;
    
    
    
    @Override
    public BookDto addBook(BookDto bookDTO) {
        try {
           
            Book book = bookService.createBook(bookMapper.bookDtoToBook(bookDTO))
                    .orElseThrow(()->new CreatingException("Cant create Book",HttpStatus.BAD_REQUEST));
            return bookMapper.bookToBookDTO(book);
        } catch (CreatingException e) {
            throw new CreatingException("Cant create Book",HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new CreatingException("Cant create Book",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void patchBook(BookDto bookDTO) {
        bookService.saveBook(bookMapper.bookDtoToBook(bookDTO));
    }

    @Override
    public BookDto getBook(Long bookId) {
        return bookMapper.bookToBookDTO(bookService.getBookById(bookId)
                .orElseThrow(()-> new CreatingException("Not found this book", HttpStatus.BAD_REQUEST)));
    }

    @Override
    public List<BookDto> getAllBooks(SearchBookFilterDTO bookFilterDTO) {
        try {
            List<Book> books = bookService.findAllBooksBySort(searchBookFilterMapper
                    .SearchBookFilterDTOToSearchBookFilter(bookFilterDTO));
            return books.stream().map(b->bookMapper.bookToBookDTO(b)).toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void removeBook(Long bookId) {
        bookService.getBookById(bookId);
    }

}
