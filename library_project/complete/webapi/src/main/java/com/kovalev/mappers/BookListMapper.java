package com.kovalev.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.kovalev.domain.book.Book;
import com.kovalev.dto.book.ListBookDto;

@Mapper (
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {BookMapper.class, DateMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        )
public interface BookListMapper {

    List<Book> toBookList(List<ListBookDto> dtoList);
    
    List<ListBookDto> toDtoBookList(List<Book> list);
    
}
