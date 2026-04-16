package com.Api.Test;

import org.testng.annotations.Test;

import com.Api.Base.AuthService;

import io.restassured.response.Response;

public class forgotPassword {
	@Test
	public void forgotPasswordTest()
	{
		AuthService authservice= new AuthService();
		Response response = authservice.forgotpassword("testautomationacademy33@gmail.com");
		System.out.println(response.asPrettyString());
	}

}
