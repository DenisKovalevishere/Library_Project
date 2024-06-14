package com.kovalev.facade;

import java.util.List;

import com.kovalev.dto.author.AuthorDto;

public interface AuthorFacade {

     AuthorDto createAthor(AuthorDto authorDTO);
    
    void patchAuthor(AuthorDto authorDto);
    
    AuthorDto getAuthor(Long authorId);
    
    List<AuthorDto> getAllAuthors();
    
    void removeAuthor(Long authorId);
}
