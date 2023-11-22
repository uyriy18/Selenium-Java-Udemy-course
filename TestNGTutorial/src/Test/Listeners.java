package Test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL " + result.getName() +" : " + result.getInstanceName());

	}

}
