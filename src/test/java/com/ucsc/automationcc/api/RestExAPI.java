package com.ucsc.automationcc.api;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;


public class RestExAPI {

    @BeforeClass
    public void setBaseURI(){
        baseURI = "https://reqres.in/api/";
    }

    @Test
    public void getAllUsers(){
        given()
                .when()
                .get("users?page=1")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getSingleUsers(){
        given()
                .when()
                .get("users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.first_name",equalTo("Janet"))
                .log().all();
    }

    @Test
    public void createUser(){
        String jsonStr = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(jsonStr)
                .post("users")
                .then()
                .assertThat()
                .statusCode(201)
                .body("name",equalTo("morpheus"))
                .body("job",equalTo("leader"))
                .log().all();
    }
}
