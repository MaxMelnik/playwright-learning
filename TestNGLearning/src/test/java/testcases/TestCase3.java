package testcases;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase3 {
	@Test(priority=1)
	public void doUserReg() {
		System.out.println("Executing user registration test");
		Assert.fail("User not registered successfully");
	}

	@Test(priority=2, dependsOnMethods="doUserReg")
	public void doLogin() {
		System.out.println("Executing login test");
	}

	@Test(priority=3)
	public void thirdTest() {
		System.out.println("Executing third test");
	}

	@Test(priority=4)
	public void fourthTest() {
		System.out.println("Executing fourth test");
	}
}
