package testcases;

import org.testng.annotations.*;

public class TestCase1 extends BaseTest{
	
	@BeforeTest
	public void creatingDBConn() {
		System.out.println("Creating db conn");
	}
	
	@AfterTest
	public void closingDBConn() {
		System.out.println("Closing db conn");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching browser");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing browser");
	}
	
	@Test(priority=1, groups="functional")
	public void doUserReg() {
		System.out.println("Executing user registration test");
	}

	@Test(priority=2, groups="functional")
	public void doLogin() {
		System.out.println("Executing login test");
	}
}
