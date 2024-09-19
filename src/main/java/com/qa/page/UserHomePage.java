package com.qa.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHomePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']") private WebElement userInfo;
	
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void getUsername() {
		wait.until(ExpectedConditions.visibilityOf(userInfo));
		System.out.println(userInfo.getText());
	}
}
