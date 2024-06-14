package com.kovalev.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.kovalev.dto.SearchBookFilter;
import com.kovalev.dto.filter.SearchBookFilterDTO;



@Mapper (
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        )
public interface SearchBookFilterMapper {

    SearchBookFilter SearchBookFilterDTOToSearchBookFilter(SearchBookFilterDTO filter);
    
    SearchBookFilterDTO SearchBookFilterToSearchBookFilterDTO(SearchBookFilter filter);
}
