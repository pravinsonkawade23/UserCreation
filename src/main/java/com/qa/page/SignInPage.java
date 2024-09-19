package com.qa.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utilities.ConfigReader;

public class SignInPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = "//div[@class='control']//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//div[@class='control']//input[@name='login[password]']")
	private WebElement signInPassword;
	@FindBy(xpath = "//div[@class='actions-toolbar']//button[@class='action login primary']")
	private WebElement signInButton;

	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void enterCreds() {
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(ConfigReader.getValue("email"));
		wait.until(ExpectedConditions.visibilityOf(signInPassword));
		signInPassword.clear();
		signInPassword.sendKeys(ConfigReader.getValue("password"));
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();
	}
}
