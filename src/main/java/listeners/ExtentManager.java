package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;

public class ExtentManager {

	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		//check if we already have extentReport object for the current session - reuse it , if you dont have the create it 
		//Since we need to maintain single report throughout the project , I dont need multiple instances , 
		//So we have written simple if condition, if the instance is already available - reuse the same instance and append all my test result in this and if not available create it 
		//if(extent==null) --> this mean there is no instance for my complete project, and i need the reference . So we have to call createInstance()
		
		if(extent==null) {
			extent =createInstance();
			return extent;
		}
		else {
			return extent;
		}
	}
	
	
	public static ExtentReports createInstance() {
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/AutomationReport"+Utility.getCurrentDateTime()+".html");
		spark.config().setDocumentTitle("Sprint 1 report");
		spark.config().setReportName("Automation Report");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		
		return extent;
	}
}
