package com.kovalev.service;

import java.util.List;
import java.util.Optional;

import com.kovalev.domain.author.Author;
import com.kovalev.exception.AlreadyExistsException;

public interface AuthorService {

    Optional<Author> getAuthorById(Long id);
    
    List<Author> getAllAuthor();
    
    Optional<Author> createAuthor(Author author) throws AlreadyExistsException;
    
    void saveAuthor(Author author) throws Exception;
    
    void removeAuthorById(Long id);
    
    List<Author> getAuthorsBySurname(String surName);
}
