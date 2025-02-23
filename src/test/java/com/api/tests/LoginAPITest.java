package com.api.tests;

import com.api.models.response.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(description = "Veriy if login API is wokring...")
    public static void loginTest(){
        RestAssured.baseURI = "http://64.227.160.186:8080/";
        RequestSpecification x = RestAssured.given();
       RequestSpecification y = x.header("Content-Type", "application/json");
        RequestSpecification z = y.body("{ \"username\": \"uday12345\", \"password\": \"uday12345\"}");
       Response response =  z.post("/api/auth/login");


       System.out.println(response.asPrettyString());


        Assert.assertEquals(response.getStatusCode(),200);
    }
}
