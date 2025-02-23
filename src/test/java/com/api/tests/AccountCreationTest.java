package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class AccountCreationTest {

    @Test(description = "Veriy if login API is wokring...")

    public static void createAccountTest() {

        SignupRequest signupRequest = new SignupRequest.Builder().userName("Disha4534")
                .email("disha@yah12o.com")
                .firstName("Dsiha333")
                .password("disha23")
                .lastName("Bhatt")
                .mobileNumber("7777777610")
                .build();

        AuthService authService = new AuthService();
          Response response = authService.signUp(signupRequest);
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
          System.out.println(response.asPrettyString());




    }
}
