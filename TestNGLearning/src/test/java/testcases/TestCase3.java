package testcases;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase3 extends BaseTest {
	@Test(priority=1, groups={"functional", "smoke"})
	public void doUserReg() {
		System.out.println("Executing user registration test");
		Assert.fail("User not registered successfully");
	}

	@Test(priority=2, groups={"functional", "smoke"}, dependsOnMethods="doUserReg")
	public void doLogin() {
		System.out.println("Executing login test");
	}

	@Test(priority=3, groups={"functional", "smoke"}, dependsOnMethods="doUserReg", alwaysRun=true)
	public void thirdTest() {
		System.out.println("Executing third test");
	}

	@Test(priority=4, groups={"bvt"}, dependsOnMethods="doUserReg")
	public void fourthTest() {
		System.out.println("Executing fourth test");
	}
}
