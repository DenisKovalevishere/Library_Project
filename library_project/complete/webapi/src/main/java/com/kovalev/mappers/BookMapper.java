package com.kovalev.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.kovalev.domain.book.Book;
import com.kovalev.dto.book.BookDto;



@Mapper (
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {DateMapper.class, AuthorListMapper.class},
                unmappedTargetPolicy = ReportingPolicy.WARN,
                nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        )
public interface BookMapper {

    
    BookDto bookToBookDTO(Book book);
    
    Book bookDtoToBook(BookDto bookDTO);
    

}
