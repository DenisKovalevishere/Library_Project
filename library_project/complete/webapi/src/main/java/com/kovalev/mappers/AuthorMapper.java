package com.kovalev.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.kovalev.domain.author.Author;
import com.kovalev.dto.author.AuthorDto;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {DateMapper.class, BookListMapper.class},
                unmappedTargetPolicy = ReportingPolicy.WARN,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        )
public interface AuthorMapper {

    AuthorDto authorToAuthorDTO(Author author);
    
    Author authorDtoToAuthor(AuthorDto authorDTO);
    
 
}
