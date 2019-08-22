package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.base.BaseClass;

/**
 * @author navin.kotamraju
 * Add New User 
 *
 */
public class AddUser_Factory extends BaseClass {

	public AddUser_Factory(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add User')]")
	WebElement webEle_AddUser;

	@FindBy(how = How.XPATH, using = "//input[@id='required']")
	WebElement webEle_NameTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement webEle_EmailTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='date']")
	WebElement webEle_DateTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id='basic_validate']/div[4]/div/textarea")
	WebElement webEle_MessageTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id='s2id_autogen3']/div/div/input")
	WebElement webEle_SelectInputTextBox;

	@FindBy(how = How.XPATH, using = "//*[@class='btn btn-success']")
	WebElement webEle_SubmitButton;

	@FindBy(how = How.XPATH, using = "//span[@for='email']")
	WebElement webEle_EmailErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//*[@id='profile-messages']/a/span")
	WebElement webEle_LogoutLink;

	@FindBy(how = How.XPATH, using = "//a[@href='index.php']")
	WebElement webEle_LogoutText;

	public AddUser_Factory clickAddUserLink() {
		click(webEle_AddUser);
		return this;
	}

	public AddUser_Factory enterDetails(String arg1, String arg2, String arg3, String arg4, String arg5) {
		writeText(webEle_NameTextBox, arg1);
		writeText(webEle_EmailTextBox, arg2);
		writeText(webEle_DateTextBox, arg3);
		writeText(webEle_MessageTextBox, arg4);
		//writeText(webEle_SelectInputTextBox, arg5);
		click(webEle_SubmitButton);
		return this;
	}

	/**
	 * Verify the error message displayed 
	 * @param message
	 * @return
	 */
	public AddUser_Factory getEmailErrorMessage(String message) {

		Assert.assertEquals(webEle_EmailErrorMessage.getText().toString(), message);
		return this;
	}

	public AddUser_Factory clickLogout() {
		click(webEle_LogoutLink);
		click(webEle_LogoutText);
		return this;
	}
}
