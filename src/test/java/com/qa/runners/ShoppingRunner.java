package com.qa.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/Shop.feature",
		glue = "com.qa.stepDefinitions",
		//tags = "@tag1",
		monochrome = true
		)

public class ShoppingRunner 
{
	
}