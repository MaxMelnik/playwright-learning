package testnglearning;

import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;

public class TestCase1 {
	@Test
	public void sampleTest() {
		ExtentListeners.test.log(Status.INFO, "Inside Sample Test");
	}
}
