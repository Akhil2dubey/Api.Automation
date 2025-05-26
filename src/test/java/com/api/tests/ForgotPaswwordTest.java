package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPaswwordTest {

	@Test(description = "verify the forgot password ")
	public void forgotPaswwordTest() {

		AuthService authService=new AuthService();
		Response response=authService.forgotPassword("akhildwivediindia@gmail.com");
		System.out.println(response.asPrettyString());
	}
}
 