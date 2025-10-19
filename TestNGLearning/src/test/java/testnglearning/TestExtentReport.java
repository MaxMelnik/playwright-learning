package testnglearning;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import extentlisteners.ExtentListeners;

public class TestExtentReport {

	public ExtentSparkReporter htmlReporter; // Create HTML file and add configuration
	public ExtentReports extent; // Attaching Reporter, Creating test cases and other sys conf
	public ExtentTest test; // maintaining the test cases, adding logs, status

//	@BeforeTest
//	public void setReporter() {
//
//		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
//
//		htmlReporter.config().setEncoding(java.nio.charset.StandardCharsets.UTF_8.name());
//		java.util.Locale.setDefault(java.util.Locale.US);
//		htmlReporter.config().setDocumentTitle("W@A Automation Report");
//		htmlReporter.config().setReportName("Automation Test Results");
//		htmlReporter.config().setTheme(Theme.DARK);
//
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//
//		extent.setSystemInfo("Automation Tester", "M. Miller");
//		extent.setSystemInfo("Build No:", "1234");
//		extent.setSystemInfo("Organization", "CLASSIFIED");
//	}
//
//	@AfterTest
//	public void endReport() {
//		extent.flush();
//	}

//	@AfterMethod
//	public void updateResults(ITestResult result) {
//		String methodName = result.getMethod().getMethodName();
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			Markup m = MarkupHelper.createLabel("Passing the test " + methodName, ExtentColor.GREEN);
//			test.pass(m);
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			Markup m = MarkupHelper.createLabel("Failing the test " + methodName, ExtentColor.RED);
//			test.fail(m);
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			Markup m = MarkupHelper.createLabel("Skipping the test " + methodName, ExtentColor.YELLOW);
//			test.skip(m);
//		}
//	}

	@Test
	public void doLogin() {
		// test = extent.createTest("Login Test");
		ExtentListeners.test.log(Status.INFO, "Enetering username");
		ExtentListeners.test.log(Status.INFO, "Enetering password");
	}

	@Test
	public void doUserReg() {
		// test = extent.createTest("User Reg Test");
		ExtentListeners.test.log(Status.INFO, "Filling form");
		Assert.fail();
	}

	@Test
	public void isSkipTest() {
		// test = extent.createTest("Skip Test");
		ExtentListeners.test.log(Status.INFO, "Entering timezone");
		throw new SkipException("Skipping the test");
	}
}
