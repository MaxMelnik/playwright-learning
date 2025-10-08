package testcases;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase2 {

	@Test
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
}
