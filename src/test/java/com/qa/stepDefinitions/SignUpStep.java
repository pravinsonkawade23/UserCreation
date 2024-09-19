package com.qa.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.qa.page.MainPage;
import com.qa.page.SignInPage;
import com.qa.page.SignUpPage;
import com.qa.page.UserHomePage;
import com.qa.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStep {

	public MainPage mainPage;
	public SignUpPage signUpPage;
	public UserHomePage userHomePage;
	public SignInPage signInPage;
	public WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver = Driver.initiateBrowser();
		this.mainPage = new MainPage(driver);
		this.signUpPage = new SignUpPage(driver);
		this.userHomePage = new UserHomePage(driver);
		this.signInPage = new SignInPage(driver);
	}

	@When("user clicks on create new account link")
	public void user_clicks_on_create_new_account_link() {
		mainPage.clickCreateAccountLink();
	}

	@When("user enters first name and last name")
	public void user_enters_first_name_and_last_name() {
		signUpPage.enterfirstNameLastName();
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		signUpPage.enterUsernamePassword();
	}

	@When("user clicks on create account button")
	public void user_clicks_on_create_account_button() {
		signUpPage.createAccount();
	}

	@Then("the new user gets created")
	public void the_new_user_gets_created() {
		userHomePage.getUsername();
	}
}
