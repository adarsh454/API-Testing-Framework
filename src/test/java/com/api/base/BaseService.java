package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    //BASE URI
    //CREATE THE REQUEST
    //HANDLE THE RESPONSE
    private static final String BASE_URI = "http://64.227.160.186:8080/";
    private RequestSpecification requestSpecification;


    static  {
        RestAssured.filters(new LoggingFilter());
    }
    protected void setAuthToken(String token){
        requestSpecification.header("Authorization", "Bearer " + token);
    }
    public BaseService(){
        requestSpecification = given().baseUri(BASE_URI);
    }

    protected Response postRequest(Object payload, String endpoint){
       return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    protected Response getRequest(String endpoint){
       return requestSpecification.given().get(endpoint);

    }


}
