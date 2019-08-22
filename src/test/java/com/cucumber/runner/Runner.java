package com.cucumber.runner;

import java.io.File;

import org.junit.AfterClass;
import org.testng.annotations.Listeners;

import com.cucumber.base.BaseClass;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import report.TestListener;

@Listeners({ TestListener.class })

@CucumberOptions(features = { "src\\test\\resources\\Features\\" }, glue = "", plugin = { "pretty","json:target/cucumber-reports/Cucumber.json",
		"com.cucumber.listener.ExtentCucumberFormatter:Extent Reports/report.html" }, snippets = SnippetType.UNDERSCORE, monochrome = true, strict = false, dryRun = false, tags = {
				"@Functional1" })

public class Runner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeExtentReport() {

		Reporter.loadXMLConfig(new File(BaseClass.strWorkingDir + "\\Yash_Cucumber_POC\\extent-config.xml"));

	}
}
