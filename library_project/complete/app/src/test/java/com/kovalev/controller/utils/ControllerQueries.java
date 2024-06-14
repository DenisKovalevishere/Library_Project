package com.kovalev.controller.utils;

public class ControllerQueries {
    public static final String DELETE_AUTHOR =
            "DELETE " +
                    "FROM book2author b2a " +
                    "WHERE b2a.author_id IN (SELECT author_id " +
                    "   FROM author a " +
                    "   WHERE (a.name =:name AND a.surname =:surname AND a.second_name =:second_name)); " +
            "DELETE " +
                    "FROM author " +
                    "WHERE author_id IN (SELECT author_id " +
                    "  FROM author a" +
                    "   WHERE (a.name =:name AND a.surname =:surname AND a.second_name =:second_name)); " +
                    " ";
    
    public static final String DELETE_BOOK = 
            "DELETE " +
                    "FROM book2author b2a " +
                    "WHERE b2a.author_id IN (SELECT book_id " +
                    "   FROM book b " +
                    "   WHERE (b.name =:name AND b.isbn =:isbn)); " +
            "DELETE " +
                    "FROM book " +
                    "WHERE book_id IN (SELECT book_id " +
                    "  FROM book b" +
                    "   WHERE (b.name =:name AND b.isbn =:isbn)); " +
                    " ";
    
    public static final String INSERT_AUTHOR =
            "INSERT INTO author " +
                    "(name, " +
                    "surname, " +
                    "second_name, " +
                    "date_of_birthday)  " +
                    "VALUES " +
                    "(:name, " +
                    ":surname, " +
                    ":second_name, " +
                    ":date_of_birthday) " +
                    "RETURNING author_id;";
    
    public static final String INSERT_BOOK =
            "INSERT INTO book " +
                    "(name, " +
                    "public_date, " +
                    "isbn)  " +
                    "VALUES " +
                    "(:name, " +
                    ":public_date, " +
                    ":isbn) " +
                    "RETURNING book_id;";
}
