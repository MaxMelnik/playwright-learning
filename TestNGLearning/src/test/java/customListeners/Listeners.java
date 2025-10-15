package customListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Passed Test -" + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("<a href=\"C:\\Users\\User\\Pictures\\Wallpapers\\Seafh.full.1327410.jpg\" target=\"_blank\">Screenshot link</a>");
		Reporter.log("<a href=\"C:\\Users\\User\\Pictures\\Wallpapers\\Seafh.full.1327410.jpg\" target=\"_blank\"><img height=200 src=\"C:\\Users\\User\\Pictures\\Wallpapers\\Seafh.full.1327410.jpg\"></a>");
		
		
		System.out.println("Capturing Screenshot for the Failed test --" + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
