package com.kovalev.controller.utils;

import java.time.LocalDate;

public final class RestAssuredFinalValues {


    //Authors
    public static final String AUTHOR1_IN_DB_NAME = "Тест1-Аркадий";
    public static final String AUTHOR1_IN_DB_SURNAME = "Тест1-Стругатский";
    public static final String AUTHOR1_IN_DB_SECONDNAME = "Тест1-Петрович";
    public static final String AUTHOR1_IN_DB_DATEOFBIRTHDAY = "2004-12-02";
    
    
    public static final String AUTHOR2_IN_DB_NAME = "Тест2-Аркадий";
    public static final String AUTHOR2_IN_DB_SURNAME = "Тест2-Стругатский";
    public static final String AUTHOR2_IN_DB_SECONDNAME = "Тест2-Петрович";
    public static final LocalDate AUTHOR2_IN_DB_DATEOFBIRTHDAY = LocalDate.of(2005, 05, 07);
   

    //Books
    public static final String BOOK1_NAME = "Тест1 Страна багровых туч";
    public static final String BOOK1_PUBLIC_DATE = "1988";
    public static final Long   BOOK1_INDIVIDUAL_SERIAL_NUMBER = 1245353783711L;
    
    public static final String BOOK2_NAME = "Тест2 Страна багровых туч";
    public static final String BOOK2_PUBLIC_DATE = "1968";
    public static final Long   BOOK2_INDIVIDUAL_SERIAL_NUMBER = 1245353787711L;
   
    public static final String BOOK3_NAME = "Тест3 Страна багровых туч";
    public static final int    BOOK3_PUBLIC_DATE = 1979;
    public static final Long   BOOK3_INDIVIDUAL_SERIAL_NUMBER = 1244453783711L;
   

    //Paths
    public static final String DEFAULT_PREFIX = "/library";


    
    
}
