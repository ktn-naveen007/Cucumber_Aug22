package com.cucumber.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumber.base.BaseClass;

public class BrowserFactory {
	public static WebDriver driver;
	public WebDriverWait wait;
	private static String strChromeDriverPath = BaseClass.strWorkingDir
			+ "\\src\\test\\resources\\Drivers\\chromedriver.exe";
	private static String strIEDriverPath = BaseClass.strWorkingDir
			+ "\\src\\test\\resources\\Drivers\\IEDriverServer3.8.exe";
	private static String strGeckoDriverPath = BaseClass.strWorkingDir
			+ "\\src\\test\\resources\\Drivers\\geckodriver.exe";
	private static String strEdgeDriverPath = BaseClass.strWorkingDir
			+ "\\src\\test\\resources\\Drivers\\EDGEWebDriver16299.exe";

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void getBrowser(String browserName) {

		if (!browserName.isEmpty() && !browserName.equals(null)) {
			// checking the type of browser
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", strChromeDriverPath);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				// capabilities.setCapability("marionette", true);
				// ExtentTestManager.getInstance();
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("Firefox")) {

				System.setProperty("webdriver.gecko.driver", strGeckoDriverPath);
				FirefoxOptions options = new FirefoxOptions();
				options.setCapability("marionette", true);
				driver = new FirefoxDriver(options);

			} else if (browserName.equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver", strIEDriverPath);
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				capabilities.setCapability("requireWindowFocus", true);
				capabilities.setCapability("ignoreZoomSetting", true);
				driver = new InternetExplorerDriver(capabilities);

			} else if (browserName.equalsIgnoreCase("EDGE")) {

				System.setProperty("webdriver.edge.driver", strEdgeDriverPath);
				driver = new EdgeDriver();

			}
		}
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 15);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
