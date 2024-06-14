package com.kovalev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kovalev.dto.book.BookDto;
import com.kovalev.dto.filter.SearchBookFilterDTO;
import com.kovalev.facade.BookFacade;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/library/books")
@AllArgsConstructor
public class BookController {

    private BookFacade bookFacade;
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public BookDto addBook(@Valid @RequestBody BookDto bookDTO) {
        return bookFacade.addBook(bookDTO);
    }
    
    @PatchMapping("/edit")
    public void patchBook(@Valid @RequestBody BookDto bookDTO) {
        bookFacade.patchBook(bookDTO);
    }
    
    @GetMapping("/book/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return bookFacade.getBook(bookId);
    }
    
    @GetMapping("/getAll")
    public List<BookDto> getAllBooks(@Valid @RequestBody SearchBookFilterDTO bookFilterDTO){
        return bookFacade.getAllBooks(bookFilterDTO);
    }
    
    @DeleteMapping("/delete/{bookId}")
    public void removeBook(@PathVariable Long bookId) {
        bookFacade.removeBook(bookId);
    }
}
