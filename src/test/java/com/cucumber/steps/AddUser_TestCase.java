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


import com.cucumber.base.BaseClass;
import com.cucumber.listener.Reporter;
import com.cucumber.pages.AddUser_Factory;
import com.cucumber.utility.BrowserFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

import com.relevantcodes.extentreports.*;

public class AddUser_TestCase extends BrowserFactory {
	public ExtentReports extent;
	public ExtentTest logger;
	 WebDriver driver;
	 
	
	@Given("^Click on Add User link$")
	public void click_on_Add_User_link() throws Throwable {
		AddUser_Factory addUser = new AddUser_Factory(driver);
		addUser.clickAddUserLink();
	}

	@Given("^Enter Name:\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_Name(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		AddUser_Factory addUser = new AddUser_Factory(driver);
		addUser.enterDetails(arg1, arg2, arg3, arg4, arg5);

	}

	@Given("^Click on Logout button$")
	public void click_on_Logout_button() throws Throwable {
		AddUser_Factory addUser = new AddUser_Factory(driver);
		addUser.clickLogout();
	}
	
	/*@AfterMethod
	 public void getResult(ITestResult result) throws Exception{
	 if(result.getStatus() == ITestResult.FAILURE){
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
	                        String screenshotPath = getScreenhot(driver, result.getName());
	 //To add it in the extent report 
	 logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
	 }else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
	 // ending test
	 //endTest(logger) : It ends the current test and prepares to create HTML report
	 extent.endTest(logger);
	 }
	 @AfterTest
	 public void endReport(){
	 // writing everything to document
	 //flush() - to write or update test information to your report. 
	                extent.flush();
	                //Call close() at the very end of your session to clear all resources. 
	                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
	                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
	                //Once this method is called, calling any Extent method will throw an error.
	                //close() - To close all the operation
	                extent.close();
	    }*/
	
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
