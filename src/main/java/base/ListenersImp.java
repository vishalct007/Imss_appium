package base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImp implements ITestListener {
	
	
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result)
	{
		test=reports.createTest(result.getMethod().getMethodName());
	}

	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,result.getMethod().getMethodName()+" got passed" );
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName()+" got Fail" );
		test.log(Status.FAIL, result.getThrowable());

		try {
			String path=BaseClass.takescreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" got skipped");
	}

	

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("../imss_appium/Reports/report.html");
		reporter.config().setDocumentTitle("Genral Store");
		reporter.config().setReportName("App Test");
		reporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("env", "qa");
		reports.setSystemInfo("platform", "Android");
		reports.setSystemInfo("author","Vishal");

	}
	
	

	@Override
	public void onFinish(ITestContext context) 
	{
		reports.flush();
	}

}
