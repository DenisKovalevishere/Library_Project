package com.kovalev.dto.author;

import java.util.List;

import com.kovalev.dto.book.ListBookDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {


    
    private Long id;
    
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surName;
    
    @NotNull
    @NotEmpty
    private String secondName;
    
    @NotNull
    @NotEmpty
    private String dateOfBirthday;
    
    private List<ListBookDto> books;
    
 
    
}
