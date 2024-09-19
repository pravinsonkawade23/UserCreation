package com.qa.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.qa.page.MainPage;
import com.qa.page.SignInPage;
import com.qa.page.UserHomePage;
import com.qa.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SignInStep {

	public MainPage mainPage;
	public UserHomePage userHomePage;
	public SignInPage signInPage;
	public WebDriver driver;

	@Given("user is present on login page")
	public void user_is_present_on_login_page() {
		driver = Driver.initiateBrowser();
		this.mainPage = new MainPage(driver);
		this.userHomePage = new UserHomePage(driver);
		this.signInPage = new SignInPage(driver);
	}

	@Given("user clicks on signin link")
	public void user_clicks_on_signin_link() {
		mainPage.clickSignInLink();
	}

	@Given("user enters email and password")
	public void user_enters_email_and_password() {
		signInPage.enterCreds();
	}

	@Given("user clicks on signin button")
	public void user_clicks_on_signin_button() {
		signInPage.clickLoginButton();
	}

	@Then("user gets logged in")
	public void user_gets_logged_in() {
		userHomePage.getUsername();
		driver = Driver.tearDown();
	}

}
