package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestCase2 extends BaseTest {

	@Test (priority=1, groups="smoke")
	public void validateTitles() {
		String expected_title = "Yahoo.com";
		String actual_title = "Gmail.com";
		
		Assert.assertEquals(actual_title, expected_title);
	}
	
	@Test
	public void validateElement() {
		Assert.assertTrue(false, "Element not found");
	}

	@Test
	public void assertFail() {
		Assert.fail("Failing the test as the condition is not met");
	}

	@Test
	public void softAssert() {
		System.out.println("Start...");
		
		SoftAssert softAssert = new SoftAssert();
		
		String expected_title = "Yahoo.com";
		String actual_title = "Gmail.com";
		
		softAssert.assertEquals(actual_title, expected_title);

		softAssert.assertEquals(true, false, "soft fail");
		
		System.out.println("...Finish");
		
		softAssert.assertAll();
	}
}
