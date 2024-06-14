package com.kovalev.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchBookFilterDTO {

    private boolean sortByName;
    
    private boolean sortByIndividualSerialBookNamber;
    
    private boolean sortByAuthor;
}
