package com.neo.apis;

import com.neo.utils.ConfigLoaders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
public static RequestSpecification getRequestSpec() {
		
		RequestSpecification rqst= new RequestSpecBuilder()
				  .setBaseUri(ConfigLoaders.getInstance().getBaseurl())			 
				  .log(LogDetail.ALL)
				  .build();
		 
		 
		 return rqst;
	}
    
	public static ResponseSpecification getResponseSpec() {
		
		ResponseSpecification resp=	 new ResponseSpecBuilder()
				 .log(LogDetail.ALL)
				 .build();
		
	
		
		return  resp;
				   
	}

}
