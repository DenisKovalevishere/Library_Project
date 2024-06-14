package com.kovalev.controller.utils;



import java.time.LocalDate;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import static com.kovalev.controller.utils.RestAssuredFinalValues.*;


public class RestAssuredUtils {

    public static void clearDb(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        deleteAllAuthorsFromDB(AUTHOR1_IN_DB_NAME, AUTHOR1_IN_DB_SURNAME, AUTHOR1_IN_DB_SECONDNAME, namedParameterJdbcTemplate);
        deleteAllBooksFromDB(BOOK1_NAME, BOOK1_INDIVIDUAL_SERIAL_NUMBER, namedParameterJdbcTemplate);
        deleteAllAuthorsFromDB(AUTHOR2_IN_DB_NAME, AUTHOR2_IN_DB_SURNAME, AUTHOR2_IN_DB_SECONDNAME, namedParameterJdbcTemplate);
        deleteAllBooksFromDB(BOOK2_NAME, BOOK2_INDIVIDUAL_SERIAL_NUMBER, namedParameterJdbcTemplate);
        deleteAllBooksFromDB(BOOK3_NAME, BOOK3_INDIVIDUAL_SERIAL_NUMBER, namedParameterJdbcTemplate);
        
    }
    
    public static void deleteAllAuthorsFromDB(String name, String surName, String secondName, 
                                              NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        namedParameterJdbcTemplate.update(
                ControllerQueries.DELETE_AUTHOR,
                Map.of("name", name, "surname", surName, "second_name", secondName)
              
        );
    }
    
    public static void deleteAllBooksFromDB(String name, Long isbc, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        namedParameterJdbcTemplate.update(        
                ControllerQueries.DELETE_BOOK,
                Map.of("name", name, "isbn", isbc)
         );
    }
    
    public static Long createTestAuthorInDB(String name, String surName, String secondName, LocalDate date,
                                            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        Long insertedId = namedParameterJdbcTemplate.queryForObject(
                ControllerQueries.INSERT_AUTHOR,
                Map.of("name", name, "surname", surName, "second_name", secondName, "date_of_birthday", date), Long.class
              
        );
        return insertedId;
    }
    
    public static Long createTestBookInDB(String name, int date, Long isbn,
                                            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        Long insertedId = namedParameterJdbcTemplate.queryForObject(
                ControllerQueries.INSERT_BOOK,
                Map.of("name", name, "public_date", date, "isbn", isbn), Long.class
              
        );
        return insertedId;
    }
}
