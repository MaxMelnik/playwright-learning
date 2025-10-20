package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import extentlisteners.ExtentListeners;

public class BaseTest {
	
	private Playwright playwright;
	public Browser browser;
	public Page page;
	private static Properties OR = new Properties();
	private static FileInputStream fis;
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@BeforeSuite
	public void setUp() {
		PropertyConfigurator.configure("./src/test/resorces/properties");
		log.info("Test Execution started!");
		
		try {
			fis = new FileInputStream("./src/test/resorces/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.info("OR Properties file loaded.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void click(String locatorKey) {
		try {
			page.locator(OR.getProperty(locatorKey)).click();
			log.info("Clicking on: " + locatorKey);
			ExtentListeners.test.info("Clicking on: " + locatorKey);
		} catch (Throwable t) {
			log.error("Error while clicking : " + t.getMessage());
			ExtentListeners.test.fail("Error while clicking : " + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	public void type(String locatorKey, String value) {
		try {
			page.locator(OR.getProperty(locatorKey)).fill(value);
			log.info("Typing in: " + locatorKey + " the value: " + value);
			ExtentListeners.test.info("Typing in: " + locatorKey + " the value: " + value);
		} catch (Throwable t) {
			log.error("Error while typing : " + t.getMessage());
			ExtentListeners.test.fail("Error while typing : " + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}
	
	public Browser getBrowser(String browserName) {
		playwright = Playwright.create();
		
		switch(browserName) {
		case "chrome":
			log.info("Launching Chrome browser");
			return playwright.chromium().launch(
					new BrowserType.LaunchOptions()
					.setChannel("chrome")
					.setHeadless(false));
		case "firefox":
			log.info("Launching Firefox browser");
			return playwright.firefox().launch(
					new BrowserType.LaunchOptions()
					.setChannel("firefox")
					.setHeadless(false));
		case "webkit":
			log.info("Launching Webkit browser");
			return playwright.webkit().launch(
					new BrowserType.LaunchOptions()
					.setHeadless(false));
		case "headless":
			log.info("Launching Headless Mode");
			return playwright.chromium().launch(
					new BrowserType.LaunchOptions()
					.setHeadless(true));
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public void navigate(Browser browser, String url) {
		page = browser.newPage();
		page.navigate(url);
		log.info("Navigate to: " + url);
	}
	
	@AfterMethod
	public void quit() {
		browser.close();
		page.close();
		playwright.close();
	}
}
