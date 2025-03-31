package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utilities.ExtentReportManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{
	//private static ExtentReports extent = ExtentReportManager.getReportInstance();
    private static ExtentTest test;
    private WebDriver driver;

    @Before
    public void beforeScenario(Scenario scenario) 
    {
        test = ExtentReportManager.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) 
    {
        if (scenario.isFailed()) 
        {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            test.log(Status.FAIL, "Test Failed");
            test.addScreenCaptureFromBase64String(new String(screenshot));
        } 
        else 
        {
            test.log(Status.PASS, "Test Passed");
        }
        ExtentReportManager.getReportInstance().flush();
    }
}