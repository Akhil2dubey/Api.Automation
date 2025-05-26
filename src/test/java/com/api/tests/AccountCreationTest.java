package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "verify the account creation")
	public void createAccountTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.username("sikh123")
				.password("sikh1234")
				.email("pllool@yahoo.com")
				.firstName("sikh")
				.lastName("bhatt")
				.mobileNumber("7777777897")
				.build();
		
		
		AuthService authService = new AuthService();
		Response response=authService.signUp(signUpRequest);
		
//		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println(response.asPrettyString());
	}
}
