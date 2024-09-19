package com.qa.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utilities.ConfigReader;

public class SignUpPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = "//div[@class='control']//input[@id='firstname']") private WebElement firstName;
	@FindBy(xpath = "//div[@class='control']//input[@id='lastname']") private WebElement lastName;
	@FindBy(xpath = "//div[@class='control']//input[@id='email_address']") private WebElement email;
	@FindBy(xpath = "//div[@class='control']//input[@id='password']") private WebElement password;
	@FindBy(xpath = "//div[@class='control']//input[@id='password-confirmation']") private WebElement confirmPassword;
	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]") private WebElement createAccount;

	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterfirstNameLastName() {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.clear();
		firstName.sendKeys(ConfigReader.getValue("first_name"));
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.clear();
		lastName.sendKeys(ConfigReader.getValue("last_name"));
	}
	
	public void enterUsernamePassword() {
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(ConfigReader.getValue("email"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(ConfigReader.getValue("password"));
		wait.until(ExpectedConditions.visibilityOf(confirmPassword));
		confirmPassword.clear();
		confirmPassword.sendKeys(ConfigReader.getValue("password"));
	}
	
	public void createAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(createAccount));
		createAccount.click();
	}
}
