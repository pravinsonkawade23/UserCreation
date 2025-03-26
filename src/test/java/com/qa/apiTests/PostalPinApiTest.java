package com.qa.apiTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostalPinApiTest 
{
	@Test
	public void pinApiTest() 
	{
		// set base URI
		RestAssured.baseURI = "https://api.postalpincode.in";

		// get request
		Response response = 
				given()
					.header("Content-Type", "application/json")
				.when()
					.get("/pincode/413004")
				.then()
					.assertThat()
					.statusCode(200)
					.contentType("application/json")
					.time(lessThan(3000L))
					.extract().response();

		System.out.println("Response: " + response.getBody().asPrettyString());
	}
}