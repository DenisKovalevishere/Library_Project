package com.kovalev.initial;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.kovalev.domain.author.Author;
import com.kovalev.domain.book.Book;
import com.kovalev.service.AuthorService;
import com.kovalev.service.BookService;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner{
    
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {        

        Author author1 = new Author();
        author1.setName("Илья");
        author1.setSurName("Ильф");
        author1.setSecondName("Арнольдович");
        author1.setDateOfBirthday(LocalDate.of(1897, 10, 15));             
        
        Author author2 = new Author();
        author2.setName("Евгений");
        author2.setSurName("Петров");
        author2.setSecondName("Vadimovich");
        author2.setDateOfBirthday(LocalDate.of(1903, 12, 13));            
        
        Author author3 = new Author();
        author3.setName("Эрик");
        author3.setSurName("Блэр");
        author3.setSecondName("Артур");
        author3.setDateOfBirthday(LocalDate.of(1903, 6, 25));     
        
        Author[] authors = {author1, author2, author3};
        
        for(Author author: authors) {
            if(beforeCreateAuthor(author).isEmpty()) {
                authorService.createAuthor(author);
            } 
        }
        
        
        List<Author> list1 = new ArrayList();
        List<Author> list2 = new ArrayList();
        list1.add(author1);
        list1.add(author2);
        list2.add(author3);
        
        Book book1 = new Book();
        book1.setName("Двенадцать стульев");
        book1.setIndividualSerialBookNamber(9785170477654L);
        book1.setPublicDate(Year.of(1927));
       
        
        
        Book book2 = new Book();
        book2.setName("Одноэтажная америка");
        book2.setIndividualSerialBookNamber(9785170477667L);
        book2.setPublicDate(Year.of(1937));
       
        
        
        Book book3 = new Book();
        book3.setName("1984");
        book3.setIndividualSerialBookNamber(9785174825767L);
        book3.setPublicDate(Year.of(1937));
        
        book1.setAuthors(list1);
        book2.setAuthors(list1);
        book3.setAuthors(list2);
        
        
        Book[] books= {book1,book2,book3};
        
        for(Book book : books) {
            if(beforeCreateBook(book).isEmpty()) {
                bookService.createBook(book);
            } 
        }

    }
    
    private Optional<Author> beforeCreateAuthor(Author author) {
        List<Author> authors = authorService.getAuthorsBySurname(author.getSurName());
        return authors.stream().filter(arg0 ->  arg0.equals(author)).findFirst();
    }
    
    private Optional<Book> beforeCreateBook(Book book) {
        return bookService.getBookByName(book.getName());
    }
    
   

}
