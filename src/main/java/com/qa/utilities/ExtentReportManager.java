package com.qa.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager 
{
	private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getReportInstance() 
    {
        if (extent == null) 
        {
        	String reportDir = System.getProperty("user.dir") + "/reports";
        	File file = new File(reportDir);
        	if(!file.exists())
        	{
        		boolean folderCreated = file.mkdirs();
        		if(folderCreated)
        		{
        			System.out.println("folder created: " + reportDir);
        		}
        		else
        		{
        			System.out.println("folder is not created");
        		}        		
        	}
        	        	
            String reportPath = reportDir + "/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("BDD Cucumber Selenium Test Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "pravin");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) 
    {
        test = extent.createTest(testName);
        return test;
    }

}