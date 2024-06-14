package com.kovalev.facade.imp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kovalev.domain.author.Author;
import com.kovalev.dto.author.AuthorDto;
import com.kovalev.exceptions.CreatingException;
import com.kovalev.exceptions.NotFoundException;
import com.kovalev.facade.AuthorFacade;
import com.kovalev.mappers.AuthorMapper;
import com.kovalev.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorFacadeImp implements AuthorFacade{
    
    private AuthorService authorService;
    
    private AuthorMapper authorMapper;
    
    
    

    @Override
    public AuthorDto createAthor(AuthorDto authorDTO) throws CreatingException{

            try {

                Author author = authorService.createAuthor(authorMapper.authorDtoToAuthor(authorDTO))
                        .orElseThrow(()->new CreatingException("Cant create Author",HttpStatus.BAD_REQUEST));
                return authorMapper.authorToAuthorDTO(author);
            } catch (CreatingException e) {
                throw new CreatingException("Cant create Author",HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                throw new CreatingException("Cant create Author",HttpStatus.BAD_REQUEST);
            }
          
                    
       
    }

    @Override
    public void patchAuthor(AuthorDto authorDto) {
        try {
            authorService.saveAuthor(authorMapper.authorDtoToAuthor(authorDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AuthorDto getAuthor(Long authorId) {
        Author author = authorService.getAuthorById(authorId)
                .orElseThrow(()->new NotFoundException("Cant create Author",HttpStatus.BAD_REQUEST));
        return authorMapper.authorToAuthorDTO(author);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthor();
        return authors.stream().map(a->authorMapper.authorToAuthorDTO(a)).toList();
    }

    @Override
    public void removeAuthor(Long authorId) {
        authorService.removeAuthorById(authorId);
    }

}
