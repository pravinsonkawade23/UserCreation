package com.qa.apiTests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginAPITest {

	@Test
	public void testLoginAPI() {
		
		RestAssured.baseURI= "https://qauser.siroapps.com/user/api/auth/getLoginTypes";
		Response response= 
				given()
					.header("Content-Type","application/json")
					.header("origin", "https://siroharmonyqa.siroapps.com")
				.when()
					.get()
				.then()
					.statusCode(530)
					//.body("maxPasswordHistory", equalTo(5))
					.extract().response();
		
		System.out.println("Response: "+ response.asPrettyString());
	}
}
