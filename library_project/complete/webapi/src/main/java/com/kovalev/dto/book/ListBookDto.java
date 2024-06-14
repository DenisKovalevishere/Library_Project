package com.kovalev.dto.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListBookDto {

    private Long id;
    
    @NotEmpty
    @NotNull
    @Size(max=50)
    private String name;
    
    @NotEmpty
    @NotNull
    private String publicDate;
    

    @NotNull
    private Long individualSerialBookNamber;
}
