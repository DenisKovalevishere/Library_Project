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

import com.kovalev.dto.author.AuthorDto;
import com.kovalev.facade.AuthorFacade;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/library/authors")
@AllArgsConstructor
public class AuthorController {

    private AuthorFacade authorFacade;
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public AuthorDto createAthor(@Valid @RequestBody AuthorDto authorDTO) {
        return authorFacade.createAthor(authorDTO);
    }
    
    @PatchMapping("/edit")
    public void patchAuthor(@Valid @RequestBody AuthorDto authorDto) {
        authorFacade.patchAuthor(authorDto);
    }
    
    @GetMapping("/author/{authorId}")
    public AuthorDto getAuthor(@PathVariable Long authorId) {
        return authorFacade.getAuthor(authorId);
    }
    
    @GetMapping("/getAll")
    public List<AuthorDto> getAllAuthors(){
        return authorFacade.getAllAuthors();
    }
    
    @DeleteMapping("/delete/{authorId}")
    public void removeAuthor(@PathVariable Long authorId) {
        authorFacade.removeAuthor(authorId);
    }
}
