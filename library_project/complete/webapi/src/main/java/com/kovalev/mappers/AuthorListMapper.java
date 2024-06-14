package com.kovalev.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.kovalev.domain.author.Author;
import com.kovalev.dto.author.ListAuthorDto;

@Mapper (
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {AuthorMapper.class, DateMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        )
public interface AuthorListMapper {

    List<Author> toAuthorList(List<ListAuthorDto> dtoList);
    
    List<ListAuthorDto> toDtoAuthorList(List<Author> list);
}
