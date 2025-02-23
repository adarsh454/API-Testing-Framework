package com.api.tests;

import com.api.base.AuthService;
import com.api.base.BaseService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;

import static io.restassured.RestAssured.given;

@Listeners(com.api.listeners.TestListener.class)

public class LoginAPITest3 {
    @Test(description = "Veriy if login API is wokring...")

    public static void loginTest(){

        LoginRequest loginRequest = new LoginRequest("adarsh1","adarsh1");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        System.out.println(response.asPrettyString());

      LoginResponse loginResponse =  response.as(LoginResponse.class);

       System.out.println(loginResponse.getToken());
       Assert.assertTrue(loginResponse.getToken() != null);

    }
}
