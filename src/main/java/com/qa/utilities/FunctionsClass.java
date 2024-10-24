package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class FunctionsClass {

	public static WebDriver driver;

	public static void captureScreenshot(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir") + "\\Screenshot");
			try {
				FileHandler.copy(source, destination);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("screenshot is not captured !!!");
			}
		}
	}
	
	public static void sendTextToField(By locator, String text) {
		
		WebElement textField= driver.findElement(locator);
		textField.clear();
		textField.sendKeys(text);
	}
}
