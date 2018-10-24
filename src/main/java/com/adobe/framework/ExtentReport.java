package com.adobe.framework;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports reporter;
	static ExtentTest test;
	ITestResult result;
	
	
	@BeforeMethod
	public static void extentReportSetup() throws IOException{
		System.out.println("Extent Report started");
		htmlReporter = new ExtentHtmlReporter("./extentReport/log.html");
		reporter = new ExtentReports();
		reporter.attachReporter(htmlReporter);
		test = reporter.createTest("My First Test Nav", "Test Completed Right");
	
		
		
	}
	@Test
	public static void extentReport(String info, String fail) throws IOException{	
		test.log(Status.INFO, info);
		test.log(Status.FAIL, fail);
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("/src/main/resources/image.png").build());
		test.addScreenCaptureFromPath("C:/Users/Admin/Pictures/image.png");
		reporter.flush();
		System.out.println("Extent Report completed");

	}
	public ITest extentsResult(ITestResult result ){
		result.getMethod().getClass();
		ITest path = null;
		
		return path;
		
	}
}
