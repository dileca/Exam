package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import frameWorkClasses.BasePage;
import frameWorkClasses.Utilities;

public class Listeners extends BasePage implements ITestListener {

	Utilities uts = new Utilities();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// when this method is triggered take a screen shot
		try {
			uts.takeSnapShot("On Test Success" + uts.timeReturn() + " .png");
			System.out.println("Listener: On Test Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		// when this method is triggered take a screen shot
		try {
			uts.takeSnapShot("On Test Failure" + uts.timeReturn() + " .png");
			System.out.println("Listener: On Test Failure");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub	
	}


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onFinish(context);
		cleanUp();	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub	
	}

}