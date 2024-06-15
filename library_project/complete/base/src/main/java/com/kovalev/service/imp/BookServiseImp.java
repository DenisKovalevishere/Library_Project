package com.kovalev.service.imp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kovalev.domain.author.Author;
import com.kovalev.domain.book.Book;
import com.kovalev.dto.SearchBookFilter;
import com.kovalev.exception.AlreadyExistsException;
import com.kovalev.repository.BookRepository;
import com.kovalev.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiseImp implements BookService{
    
    private BookRepository bookRepository;
    

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Book> createBook(Book book) throws AlreadyExistsException {
        populateBook(book);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void removeBookById(Long id) {
        bookRepository.deleteById(id);
    }
    
    private void populateBook(Book book) throws AlreadyExistsException {
        Optional<Book> foundBook = bookRepository.findBookByName(book.getName());
        if(foundBook.isPresent()) {
            throw new AlreadyExistsException("This book is present", book.getClass().toString());
        }
    }

    @Override
    public List<Book> findAllBooksBySort(SearchBookFilter filter) throws Exception {
        return populateFindAllBook(filter);
    }
    
    private SearchBookFilter populateSearchBookFilter(SearchBookFilter filter) throws Exception {
        if (filter.isSortByAuthor() == true && filter.isSortByIndividualSerialBookNamber() == false && filter.isSortByName() == false) {
            return filter;
        } if(filter.isSortByAuthor() == false && filter.isSortByIndividualSerialBookNamber() == true && filter.isSortByName() == false) {
            return filter;
        } if(filter.isSortByAuthor() == false && filter.isSortByIndividualSerialBookNamber() == false && filter.isSortByName() == true) {
            return filter;
        } else {
            throw new Exception("The filter must have only one parameter");
        }
    }
    
    private List<Book> populateFindAllBook(SearchBookFilter filter) throws Exception{
        SearchBookFilter correctFilter = populateSearchBookFilter(filter);
        if(correctFilter.isSortByAuthor()==true) {  
           return bookRepository.findAllBookAndSortByAuthor();
        } else if(correctFilter.isSortByIndividualSerialBookNamber() == true) {
            return bookRepository.findAllBookAndSortByISBC();
        } else {
            return bookRepository.findAllBookAndSortByName();
        }
        
    }
    

    @Override
    public Optional<Book> getBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

}

class SortedBooksComparator implements Comparator<Book> {

    @Override
    public int compare(Book arg0, Book arg1) {
        List<Author> listAuthors1 = arg0.getAuthors();
        List<Author> listAuthors2 = arg1.getAuthors();
        
        if(listAuthors1.isEmpty() && listAuthors2.isEmpty()) {
            return arg0.compareTo(arg1);
        } else if(listAuthors1.isEmpty() && listAuthors2!=null) {
            return -1;
        } else if(listAuthors1!=null && listAuthors2.isEmpty()) {
            return 1;
        } else {
            Collections.sort(arg0.getAuthors());
            Collections.sort(arg1.getAuthors());
           
            return arg0.getAuthors().get(0).compareTo(arg1.getAuthors().get(0));
        }
    }
    
}
    

