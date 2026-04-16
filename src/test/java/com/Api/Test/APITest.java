package com.Api.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.lessThan;

public class APITest {

	public static void main(String[] args) {

		
		RequestSpecification reqspec= new RequestSpecBuilder()
										.setBaseUri("http://64.227.160.186:8080/api/auth/login")
										.addHeader("Content-Type", "application/json")
										.build();
		
		
		ResponseSpecification resspec= new ResponseSpecBuilder()
										.expectStatusCode(200)
										.expectResponseTime(lessThan(200L))
										.build();
		
		
		RestAssured.given()
		.spec(reqspec)
		.when()
		.get()
		.then()
		.spec(resspec)
		.log().all();
	}

}
