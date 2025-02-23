package com.api.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest2 {

    @Test(description = "Veriy if login API is wokring...")
    public static void loginTest(){

       Response response = given()
               .baseUri("http://64.227.160.186:8080/")
               .header("Content-Type", "application/json")
               .body("{ \"username\": \"uday12345\", \"password\": \"uday12345\"}")
               .post("/api/auth/login");
       System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(),200);

    }
}
