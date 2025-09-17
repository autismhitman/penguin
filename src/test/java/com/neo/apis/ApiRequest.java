package com.neo.apis;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ApiRequest {
	
	
	public static Response post(String endPoint, Headers headers, HashMap<String,Object> formParams, Cookies cookies) {
		
		return RestAssured.given(SpecBuilder.getRequestSpec()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
        when().
                post(endPoint).
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
	}
	
	 public static Response get(String endPoint, Cookies cookies){
	        return RestAssured.given(SpecBuilder.getRequestSpec()).
	                cookies(cookies).
	        when().
	                get(endPoint).
	        then().spec(SpecBuilder.getResponseSpec()).
	                extract().
	                response();
	    }

}
