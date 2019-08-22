package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.cucumber.base.BaseClass;

public class LoginPage_Factory extends BaseClass {

	public LoginPage_Factory(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='loginform']/div[2]/div/div/input")
	WebElement webEle_usernameTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id='loginform']/div[3]/div/div/input")
	WebElement webEle_passwordTextBox;

	@FindBy(how = How.XPATH, using = "//*[@class='pull-right']")
	WebElement webEle_LoginButton;

	@FindBy(how = How.ID, using = "to-recover")
	WebElement webEle_SignUpButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='First Name']")
	WebElement webEle_FirstName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Last Name']")
	WebElement webEle_LastName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	WebElement webEle_Email;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	WebElement webEle_Password;

	@FindBy(how = How.XPATH, using = "//*[@id='loginform']/div[6]/span[2]/a")
	WebElement webEle_SubmitButton;

	public LoginPage_Factory clickSignUp() {
		click(webEle_SignUpButton);
		return this;
	}

	public LoginPage_Factory fillSignUpForm(String firstname, String lastname, String email, String password) {
		writeText(webEle_FirstName, firstname);
		writeText(webEle_LastName, lastname);
		writeText(webEle_Email, email);
		writeText(webEle_Password, password);
		click(webEle_SubmitButton);
		return this;
	}

	public LoginPage_Factory goToUrl(String url) {
		driver.get(url);
		return this;
	}

	public LoginPage_Factory enterUsername(String username) {
		writeText(webEle_usernameTextBox, username);
		return this;
	}

	public LoginPage_Factory enterPassword(String password) {
		writeText(webEle_passwordTextBox, password);
		return this;
	}

	public LoginPage_Factory clickOnSignInButton() {
		click(webEle_LoginButton);
		return this;
	}

	public LoginPage_Factory verifyTitle(String expectedText) {
		assertEquals(driver.getTitle(), expectedText);
		return new LoginPage_Factory(super.driver);

	}

	public LoginPage_Factory quitDriver() {
		
		driver.quit();

		return this;
	}
}
