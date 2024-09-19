package com.qa.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	public WebDriver driver;
	public WebDriverWait wait;
	@FindBy(linkText = "Create an Account") private WebElement createAccountLink;
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]") private WebElement signInLink;

	public MainPage(WebDriver driver) {		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickCreateAccountLink() {
		wait.until(ExpectedConditions.elementToBeClickable(createAccountLink));
		createAccountLink.click();
	}
	
	public void clickSignInLink() {
		wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
	}
}
