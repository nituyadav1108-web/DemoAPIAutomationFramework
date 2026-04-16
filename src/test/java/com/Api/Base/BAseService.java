package com.Api.Base;

import static io.restassured.RestAssured.*;

import com.Api.filters.LoggingFilter;
import com.Api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BAseService {
	
	private static final String BASE_URI="http://64.227.160.186:8080/";
	
	private RequestSpecification requestSpecification;
	
	static{
		RestAssured.filters(new LoggingFilter());
	}

	public BAseService() {
		requestSpecification= given().baseUri(BASE_URI);
	}
	
	protected void setToken(String Token)
	{
	 	requestSpecification.header("Authorization", "Bearer " + Token);
	}
	
	protected Response postRequest(Object payload, String endpoint)
	{
	return	requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	protected Response getRequest(String endpoint)
	{
	return	requestSpecification.get(endpoint);
	}
	protected Response putRequest(Object payload, String endpoint)
	{
	return	requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	

}
