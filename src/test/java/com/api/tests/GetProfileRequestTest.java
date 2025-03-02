package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test(description = "Test Profile")

    public void getProfileInfoTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("adarsh1","adarsh1"));
       LoginResponse loginResponse = response.as(LoginResponse.class);
       System.out.println(loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());

        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
       System.out.println(userProfileResponse.getUsername());

    }

}
