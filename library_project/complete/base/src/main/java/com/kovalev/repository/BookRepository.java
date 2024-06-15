package com.kovalev.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kovalev.domain.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
  
    Optional<Book> findBookByName(String name);
    
    
    @Query(value = 
            "SELECT b FROM Book b "+
            "LEFT JOIN b.authors a "+
            "ORDER BY coalesce(a.surName, 'unknown') ASC"
            )
    List<Book> findAllBookAndSortByAuthor();
    
    @Query(value = 
            "SELECT b FROM Book b "+
            "ORDER BY coalesce(b.name, 'unknown') ASC"
            )
    List<Book> findAllBookAndSortByName();
    
    @Query(value = 
            "SELECT b FROM Book b "+
             "ORDER BY b.individualSerialBookNamber ASC"
            )
    List<Book> findAllBookAndSortByISBC();
}
