package com.qa.apiTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostApi 
{
	@Test
	public void checkPostApi()
	{
		/*"name": "morpheus",
	    "job": "leader"*/
		
		RestAssured.baseURI = "https://reqres.in";
		String requestBody = "{\"name\": \"morpheus\", \"job\": \"leader\" }";
		//conflict
		Response response = 
				given()
					.header("Content-Type", "application/json")
					.body(requestBody)
				.when()
					.post("/api/users")
				.then()
					.assertThat()
					.statusCode(201)
					.time(lessThan(2000L))
					.body("name", equalTo("morpheus"))
					.body("job",equalTo("leader"))
					.header("Content-Type", containsString("application/json"))
					.extract().response();
		
		System.out.println("Response: " + response.getBody().asPrettyString());
	}
}
