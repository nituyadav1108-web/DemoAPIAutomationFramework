package com.Api.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Api.Base.AuthService;
import com.Api.Base.UserProfileManagementService;
import com.Api.models.request.LoginRequest;
import com.Api.models.response.LoginResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfileInfoTest()
	{
		//http://64.227.160.186:8080/swagger-ui/index.html#/Authentication/authenticateUser
		AuthService authservice= new AuthService();
		Response response = authservice.login(new LoginRequest("nitzs", "nitz1234"));
		System.out.println(response.asPrettyString());
		LoginResponse loginresponse = response.as(LoginResponse.class);
		String token = loginresponse.getToken();
		Assert.assertNotNull(token, "Token is null");

       

		System.out.println(loginresponse.getToken());
		//System.out.println(loginresponse.getToken());
//		loginresponse.getToken();
		UserProfileManagementService userinfo= new UserProfileManagementService();
	    Response response1=userinfo.getProfile(token);
		System.out.println(response1.asPrettyString());
	}
}
