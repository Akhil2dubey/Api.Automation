package com.api.tests;

import java.net.Authenticator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.request.ProfileRequest.Builder;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void UpdateProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("akhil", "test12348"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());

		System.out.println("------------------");

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response =userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "akhil");

		System.out.println("------------------");

		ProfileRequest profilerequest = new ProfileRequest.Builder().firstName("akhil").lastName("d")
				.email("akhildwivediindia@gmail.com").mobileNumber("9755128188").build();
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profilerequest);
		System.out.println(response.asPrettyString());

	}
}
