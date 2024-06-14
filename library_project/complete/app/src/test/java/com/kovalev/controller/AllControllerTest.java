package com.kovalev.controller;



import static com.kovalev.controller.utils.RestAssuredUtils.*;
import static com.kovalev.controller.utils.RestAssuredUtils.createTestBookInDB;
import static com.kovalev.controller.utils.RestAssuredFinalValues.*;
import static org.hamcrest.Matchers.hasToString;
import static com.kovalev.controller.utils.RestAssuredUtils.clearDb;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.kovalev.IntegrationTestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AllControllerTest extends IntegrationTestBase{
    
    private static Long insertedAuthorId = 0L;
    private static Long insertedBookId = 0L;
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = super.getHost();
        clearDb(namedParameterJdbcTemplate);
       
        insertedAuthorId = createTestAuthorInDB(AUTHOR2_IN_DB_NAME,AUTHOR2_IN_DB_SURNAME,
                AUTHOR2_IN_DB_SECONDNAME, AUTHOR2_IN_DB_DATEOFBIRTHDAY, namedParameterJdbcTemplate);
       
        insertedBookId = createTestBookInDB(BOOK3_NAME, BOOK3_PUBLIC_DATE, BOOK3_INDIVIDUAL_SERIAL_NUMBER, 
                namedParameterJdbcTemplate);
    }
    
    @AfterEach
    void tearDown() {
        clearDb(namedParameterJdbcTemplate);
    }
    
    @Test
    void createAuthorTest() {
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .body(String.format("""
                    {
                        
                        "name":"%s",
                        "surName":"%s",
                        "secondName":"%s",
                        "dateOfBirthday":"%s"
                                                }"""

                    ,AUTHOR1_IN_DB_NAME,
                     AUTHOR1_IN_DB_SURNAME,
                     AUTHOR1_IN_DB_SECONDNAME,
                     AUTHOR1_IN_DB_DATEOFBIRTHDAY))
            .when()
            .post(DEFAULT_PREFIX+"/authors"+"/create")
            .then()
            .assertThat()
            .statusCode(HttpStatus.CREATED.value())
            .body("size()", is(6))
            .body("id", notNullValue())
            .body("name", is(AUTHOR1_IN_DB_NAME))
            .body("surName", is(AUTHOR1_IN_DB_SURNAME))
            .body("secondName", is(AUTHOR1_IN_DB_SECONDNAME))
            .body("dateOfBirthday", is(AUTHOR1_IN_DB_DATEOFBIRTHDAY))
            .body("books", nullValue());
    }
    
    @Test
    void createBook1Test() {
        RestAssured
        .given()
        .contentType(ContentType.JSON)
        .body(String.format("""
                    {
                        
                        "name":"%s",
                        "publicDate":"%s",
                        "individualSerialBookNamber":"%s"
                                                }"""

                    ,BOOK1_NAME,
                     BOOK1_PUBLIC_DATE,
                     BOOK1_INDIVIDUAL_SERIAL_NUMBER))
        .when()
        .post(DEFAULT_PREFIX+"/books"+"/add")
        .then()
        .assertThat()
        .statusCode(HttpStatus.CREATED.value())
        .body("size()", is(5))
        .body("id", notNullValue())
        .body("name", is(BOOK1_NAME))
        .body("publicDate", is(BOOK1_PUBLIC_DATE))
        .body("individualSerialBookNamber", is(BOOK1_INDIVIDUAL_SERIAL_NUMBER))
        ;

    }
    
    @Test
    void createBook2Test() {
        RestAssured
        .given()
        .contentType(ContentType.JSON)
        .body(String.format("""
                    {
                        
                        "name":"%s",
                        "publicDate":"%s",
                        "individualSerialBookNamber":"%s",
                        "authors":[{"id":"%d"
                                        }]
                                                }"""

                    ,BOOK2_NAME,
                     BOOK2_PUBLIC_DATE,
                     BOOK2_INDIVIDUAL_SERIAL_NUMBER,
                     insertedAuthorId))
        .when()
        .post(DEFAULT_PREFIX+"/books"+"/add")
        .then()
        .assertThat()
        .statusCode(HttpStatus.CREATED.value())
        .body("size()", is(5))
        .body("id", notNullValue())
        .body("name", is(BOOK2_NAME))
        .body("publicDate", is(BOOK2_PUBLIC_DATE))
        .body("individualSerialBookNamber", is(BOOK2_INDIVIDUAL_SERIAL_NUMBER))
        .body("authors[0].id", hasToString(insertedAuthorId.toString()))
        ;

    }
    
    
    @Test
    void getAuthorTest() {
       RestAssured
      .given()
      .contentType(ContentType.JSON)
      .pathParam("authorId", insertedAuthorId)
      .when()
      .get(DEFAULT_PREFIX+"/authors" + "/author/{authorId}")
      .then()
      .assertThat()
      .statusCode(HttpStatus.OK.value())
      .body("id", hasToString(insertedAuthorId.toString()))
      .body("name", is(AUTHOR2_IN_DB_NAME))
      .body("surName", is(AUTHOR2_IN_DB_SURNAME))
      .body("secondName", is(AUTHOR2_IN_DB_SECONDNAME))
      .body("dateOfBirthday", is(AUTHOR2_IN_DB_DATEOFBIRTHDAY.toString()))
      ;
    }
    
    @Test
    void getBookTest() {
       RestAssured
      .given()
      .contentType(ContentType.JSON)
      .pathParam("bookId", insertedBookId)
      .when()
      .get(DEFAULT_PREFIX+"/books" + "/book/{bookId}")
      .then()
      .assertThat()
      .statusCode(HttpStatus.OK.value())
      .body("name", is(BOOK3_NAME))
      .body("publicDate", hasToString(String.valueOf(BOOK3_PUBLIC_DATE)))
      .body("individualSerialBookNamber", is(BOOK3_INDIVIDUAL_SERIAL_NUMBER))
      ;
    }
    
}
