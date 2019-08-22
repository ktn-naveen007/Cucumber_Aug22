package com.cucumber.steps;

import java.io.IOException;

import com.cucumber.base.BaseClass;
import com.cucumber.pages.LoginPage_Factory;
import com.cucumber.utility.BrowserFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;

public class SignUp_TestCase extends BrowserFactory{
	
	
	@Then("^Click on Sign Up button$")
	public void click_on_Sign_Up_button() throws Throwable {
		LoginPage_Factory lp=new LoginPage_Factory(driver);
		lp.clickSignUp();
	}
	@Then("^Enter Details:\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_Details(String firstname, String lastname, String email, String password) throws Throwable {
		LoginPage_Factory lp=new LoginPage_Factory(driver);
		lp.fillSignUpForm(firstname, lastname, email, password);
	}
}
