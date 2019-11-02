package testnglearning;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("<a href=\"F:/screenshot/se.png\" target=\"_blank\">screenshot captured</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"F:/screenshot/se.png\" target=\"_blank\"><img src=\"F:/screenshot/se.png\" height=200 width=200></a>");
		
		
		
		//System.out.println("Capture screenshot");
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
