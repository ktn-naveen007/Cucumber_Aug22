package com.cucumber.steps;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.cucumber.base.BaseClass;
import com.cucumber.pages.LoginPage_Factory;
import com.cucumber.utility.BrowserFactory;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login_TestCase extends BrowserFactory {
	
	
	@Given("^Open browser as \"([^\"]*)\"$")
	public void open_browser_as(String arg1) throws Throwable {
		// getReportConfigPath();
		getBrowser(arg1);
	}

	@Given("^Enter the URL as \"([^\"]*)\"$")
	public void enter_the_URL_as(String url) throws Throwable {
		LoginPage_Factory homepage = new LoginPage_Factory(driver);
		homepage.goToUrl(url);
	}

	@Then("^Title should be \"([^\"]*)\"$")
	@Test
	public void title_should_be(String arg1) throws Throwable {
		LoginPage_Factory homepage = new LoginPage_Factory(driver);
		homepage.verifyTitle(arg1);
	}

	@Given("^Enter Username and Password$")
	@Test
	public void enter_Username_and_Password(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		LoginPage_Factory lp = new LoginPage_Factory(driver);
		lp.enterUsername(data.get(0).get(0)).enterPassword(data.get(0).get(1));
	}

	@Given("^Click on login button$")
	@Test
	public void click_on_login_button() throws Throwable {
		LoginPage_Factory homepage = new LoginPage_Factory(driver);
		homepage.clickOnSignInButton();
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		LoginPage_Factory homepage = new LoginPage_Factory(driver);
		homepage.quitDriver();
		
	}
}
