package com.api.models.request;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;


import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfileInforTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("akhil", "test12348"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userResponse=response.as(UserProfileResponse.class);
		System.out.println(userResponse.getFirstName());
	}
}
