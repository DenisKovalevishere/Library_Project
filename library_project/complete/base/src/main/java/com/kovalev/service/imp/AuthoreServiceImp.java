package com.kovalev.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kovalev.domain.author.Author;
import com.kovalev.exception.AlreadyExistsException;
import com.kovalev.repository.AuthorRepository;
import com.kovalev.service.AuthorService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class AuthoreServiceImp implements AuthorService {

    private AuthorRepository authorRepository;


    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Author> createAuthor(Author author) throws AlreadyExistsException {
        populateAuthor(author);

        return Optional.of(authorRepository.save(author));
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) throws Exception {
        populateAuthor(author);
        authorRepository.save(author);
    }

    @Override
    @Transactional
    public void removeAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    private void populateAuthor(Author searchAuthor) throws AlreadyExistsException {
        List<Author> authors = authorRepository.findBySurName(searchAuthor.getSurName());
        Optional<Author> foundAuthor = authors.stream().filter(author -> author.equals(searchAuthor)).findFirst();
        if (foundAuthor.isPresent()) {
            throw new AlreadyExistsException("This author is present", searchAuthor.getClass().toString());
        }

    }

    @Override
    public List<Author> getAuthorsBySurname(String surName) {
        return authorRepository.findBySurName(surName);
    }
    
   
    

}
