package com.Api.Base;

import java.util.HashMap;

import com.Api.models.request.LoginRequest;

import io.restassured.response.Response;

public class AuthService extends BAseService{
	
	private static final String BASE_URL="api/auth";
	
	public Response login(LoginRequest payload)
	{
		return postRequest(payload, BASE_URL+"/login");
	}

	public Response forgotpassword(String emailaddress)
	{
		HashMap<String,String> payload= new HashMap<String,String>();
		payload.put("email", emailaddress);
		return postRequest(payload, BASE_URL+"/forgot-password");
	}
}
