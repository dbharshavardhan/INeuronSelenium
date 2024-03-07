package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browserFactory.BrowserFactory;
import helper.Utility;

public class ExtentTestNGITestListener implements ITestListener{

	ExtentReports extent =ExtentManager.getInstance();

	
	//we need thread local for each ExtentTest type
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) 
	{
	  //test start - add test
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		//add pass logs
		parentTest.get().pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotAsBase64(BrowserFactory.getBrowserInstance())).build());
	}
	
	public void onTestFailure(ITestResult result) 
	{
		WebDriver driver=BrowserFactory.getBrowserInstance();
		String base64 = Utility.captureScreenshotAsBase64(driver);
		
		//add fail logs, exception trace , add screenshot
		parentTest.get().fail("Test Failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		//add skip logs
		parentTest.get().skip("Test Skipped");
	}
	
	public void onFinish(ITestContext context) 
	{
		//test finish - flush
		extent.flush();
	}
}
