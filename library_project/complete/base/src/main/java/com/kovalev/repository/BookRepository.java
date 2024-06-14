package com.kovalev.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kovalev.domain.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
  
    Optional<Book> findBookByName(String name);
}
