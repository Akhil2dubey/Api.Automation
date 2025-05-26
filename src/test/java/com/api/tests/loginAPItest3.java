package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import com.api.models.request.ForgetPasswordRequest;
import com.api.models.request.LoginRequest;
import com.api.models.response.ForgetPasswordResponse;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listener.TestListener.class)
public class loginAPItest3 {

	AuthService authaService = new AuthService();

	@Test(priority=1)
	public void logintest() {
		LoginRequest loginRequest = new LoginRequest("akhil", "test1234");

		Response response = authaService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getStatus());
		System.out.println(loginResponse.getTimestamp());
		System.out.println(loginResponse.getMessage());

		// Assert.assertEquals(loginResponse.getStatus(), 401);
	}

	@Test(priority=2)
	public void forgetpassword() {
		ForgetPasswordRequest forgetpassword = new ForgetPasswordRequest("akhildwivediindia@gmail.com");

		Response response = authaService.forgotPassword("");

		ForgetPasswordResponse forgetpasswordresponse = response.as(ForgetPasswordResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println(forgetpasswordresponse.getMessage());

	}
	@Test(priority=3)
	public void resetpassword() {
		
	}

}
