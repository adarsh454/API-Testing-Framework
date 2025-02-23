package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test
    public void updateProfileTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("adarsh1","adarsh1"));
       LoginResponse loginResponse = response.as(LoginResponse.class);
       System.out.println(response.asPrettyString());

       System.out.println("---------------------------------------------------");
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
       response = userProfileManagementService.getProfile(loginResponse.getToken());
       System.out.println(response.asPrettyString());
       UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

        Assert.assertEquals(userProfileResponse.getUsername(), "adarsh1");

        System.out.println("---------------------------------------------------");
        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Adarsh")
                .lastName("Chaurasia")
                .email("adarshchaurasia06@gmail.com")
                .mobileNumber("9999999999")
                .build();

        response = userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest);
        System.out.println(response.asPrettyString());



    }
}
