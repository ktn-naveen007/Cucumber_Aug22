package com.cucumber.steps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.cucumber.listener.Reporter;
import com.cucumber.pages.AddUser_Factory;
import com.cucumber.utility.BrowserFactory;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class InvalidEmail_TestCase extends BrowserFactory {
	

	@Given("^Invalid Email:\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void invalid_Email(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		AddUser_Factory addUser = new AddUser_Factory(driver);
		addUser.enterDetails(arg1, arg2, arg3, arg4, arg5);
	}

	@Then("^Error message should be shown as \"([^\"]*)\"$")
	public void for_Error_message_should_be_shown_as(String arg1) throws Throwable {
		AddUser_Factory addUser = new AddUser_Factory(driver);
		addUser.getEmailErrorMessage(arg1);
	}
	
	 @After
	    public void tearDown(Scenario scenario) throws IOException {
	        if (scenario.isFailed()) {
	           File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           
	                  FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "/FailedTestsScreenshots/"+scenario.getName()+".png"));
	                  
	                  File destinationPath = new File(System.getProperty("user.dir") + "/FailedTestsScreenshots/"+scenario.getName()+".png");
	                  
	                  Reporter.addScreenCaptureFromPath(destinationPath.toString());
	                  System.out.println("Screenshot captured");
	        }
	    }

}
