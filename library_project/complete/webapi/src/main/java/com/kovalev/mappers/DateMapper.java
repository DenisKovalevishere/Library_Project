package com.kovalev.mappers;



import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateMapper {
    
    String DATE_PATTERN = "yyyy-MM-dd";
    String YEAR_PATTERN = "yyyy";
    
    public LocalDate asLocalDate(String date) {
        return date == null ? null :  LocalDate.parse(date);
    }

    public String asString(LocalDate localDate) {
        return localDate == null ? null : localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
    
    public Year asYear(String year) {
        return year == null ? null : Year.parse(year);
    }
    
    public String asStringYear(Year year) {
        return year == null ? null : year.format(DateTimeFormatter.ofPattern(YEAR_PATTERN));
    }
}
