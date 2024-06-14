package com.kovalev.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchBookFilter {
    
    private boolean sortByName;
    private boolean sortByIndividualSerialBookNamber;
    private boolean sortByAuthor;
    
    @Override
    public int hashCode() {
        return Objects.hash(sortByAuthor, sortByIndividualSerialBookNamber, sortByName);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SearchBookFilter other = (SearchBookFilter) obj;
        return sortByAuthor == other.sortByAuthor && sortByIndividualSerialBookNamber == other.sortByIndividualSerialBookNamber && sortByName == other.sortByName;
    }
    
    
    

}
