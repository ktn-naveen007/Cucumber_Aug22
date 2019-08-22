package com.cucumber.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.utils.FileUtil;

public class BaseClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public static String strWorkingDir = System.getProperty("user.dir").toString();
	public SoftAssert softAssert = new SoftAssert();

	public BaseClass() {
		// TODO Auto-generated constructor stub
	}

	@AfterSuite
	public void softAssertSample() {
		softAssert.assertAll();
	}

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}

	// Wait Wrapper Method
	public void waitVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Click Method
	public void click(WebElement element) {
		waitVisibility(element);
		element.click();
	}

	// Write Text
	public void writeText(WebElement element, String text) {
		waitVisibility(element);
		element.clear();
		element.sendKeys(text);
	}

	// Read Text
	public String readText(WebElement elementBy) {
		waitVisibility(elementBy);
		return elementBy.getText();
	}

	// Assert
	public void assertEquals(String actual, String expectedText) {
		Assert.assertEquals(actual, expectedText);

	}

}
