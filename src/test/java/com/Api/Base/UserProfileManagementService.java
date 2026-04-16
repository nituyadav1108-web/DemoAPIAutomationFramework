package com.Api.Base;

import com.Api.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BAseService {
	
	private static final String BASE_URL="api/users";
	
	public Response getProfile(String token)
	{
	setToken(token);
	return	getRequest(BASE_URL+"/profile");
	}
	
	public Response updateProfile(String token, ProfileRequest payload)
	{
	setToken(token);
	return	putRequest(payload,BASE_URL+"/profile");
	}

}
