package com.Api.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Api.Base.AuthService;
import com.Api.models.request.LoginRequest;
import com.Api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
	@Test(description= "verify api login is working!..")
	public void loginTest()
	{
		baseURI="http://64.227.160.186:8080/";
		AuthService auth= new AuthService();
		LoginRequest login= new LoginRequest("nitzs", "nitz1234");
		 Response response= auth.login(login);
		 LoginResponse loginresponse = response.as(LoginResponse.class);
		
	   System.out.println(response.asPrettyString());
	   System.out.println(loginresponse.getToken());
	   Assert.assertEquals(response.getStatusCode(),200);
	   Assert.assertTrue(loginresponse.getToken() != null);
	  
		
	}

}
 