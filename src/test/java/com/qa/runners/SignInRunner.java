package com.qa.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/SignIn.feature", 
		glue = "com.qa.stepDefinitions", 
		tags = "@tag2", 
		plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		monochrome = true)

public class SignInRunner {
}
