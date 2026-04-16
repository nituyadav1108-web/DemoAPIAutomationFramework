package com.Api.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Api.Base.AuthService;
import com.Api.Base.UserProfileManagementService;
import com.Api.models.request.LoginRequest;
import com.Api.models.request.ProfileRequest;
import com.Api.models.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.Api.listeners.TestListener.class)
public class UpdateProfileTest {
	@Test
	public void updateUserProfileTest() {
		
		AuthService authservice= new AuthService();
		Response response=authservice.login(new LoginRequest("nitzs", "nitz1234"));
		LoginResponse loginresponse = response.as(LoginResponse.class);
		String token=loginresponse.getToken();
		Assert.assertNotNull(token, "token is null");
		

		UserProfileManagementService userprofile= new UserProfileManagementService();
		response=userprofile.getProfile(token);
		System.out.println(response.asPrettyString());
		
		ProfileRequest profilerequest= new ProfileRequest.Builder().firstName("Nituyadab").lastName("bajrangi")
				.email("abc@qweqqq").mobileNumber("1234567890").build();
		
		response=userprofile.updateProfile(token, profilerequest);
		System.out.println(response.asPrettyString());
	}
}
