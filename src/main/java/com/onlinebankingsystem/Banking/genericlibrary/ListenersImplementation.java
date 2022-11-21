package com.onlinebankingsystem.Banking.genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenersImplementation  implements ITestListener{

	ExtentReports report ;
	ExtentTest test ;
	public void onTestStart(ITestResult result) {
	String methodName=result.getMethod().getMethodName();
	test=report.createTest(methodName);
	Reporter.log(methodName+"--TestScript Execution Started--");
	}

	
	
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();	
		test.log(Status.PASS,methodName+"-->Passed");
		Reporter.log(methodName+"------>Script executes seucessfully");
	}

	
	
	public void onTestFailure(ITestResult result) {
		String failedScript=result.getMethod().getMethodName();
		
		String fScript = failedScript+ new Java_Utilities().getSystemDateInFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+fScript+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"-->skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(methodName+"-->script skipped");
	}

	
	
	public void onStart(ITestContext context) {
		//execution starts here
		//configure the report
	ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
	htmlreport.config().setDocumentTitle("Online banking execution report");
	htmlreport.config().setTheme(Theme.DARK);
	htmlreport.config().setReportName("TIGERLION reports");
	report =new ExtentReports();
	
	report.attachReporter(htmlreport);
	report.setSystemInfo("Base_Browser", "chrome");
	report.setSystemInfo("OS", "Windows10");
	report.setSystemInfo("Base_Url", "http://rmgtestingserver/domain/Online_Banking_System/");
	report.setSystemInfo("reporterName", "Dinesh Vundrala");
	
	}
	

	public void onFinish(ITestContext context) {
	//consolidate all the parameters and generate the report
		report.flush();
		
	}

	
}
