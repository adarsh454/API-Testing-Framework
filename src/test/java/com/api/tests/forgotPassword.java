package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class forgotPassword {
    @Test(description = "Verify if forgot password API is wokring...")

   public void forgotPassword(){

        AuthService authService = new AuthService();
       Response response = authService.forgotPassword("disha@yah12o.com");
       System.out.println(response.asPrettyString());

    }



}
