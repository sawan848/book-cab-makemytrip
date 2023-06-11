package com.makemytrip.testUtils;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.makemytrip.testBase.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter  sparkReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	private String reportName;
	

	public void onStart(ITestContext context) {
		String time=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName="Test-Report-"+time+".html";
		extentReport = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(".\\reports\\" +reportName);
        extentReport.attachReporter(sparkReporter);

        sparkReporter.config().setOfflineMode(true);
		sparkReporter.config().setDocumentTitle("MakeMyTrip Automation Report");
		sparkReporter.config().setReportName("MakeMyTrip Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setEncoding("UTF-8");


		extentReport.setSystemInfo("Application", "MakeMyTrip");
		extentReport.setSystemInfo("Module", "Admin");
		extentReport.setSystemInfo("Sub Module", "Customers");
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Environment","QA");		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.log(Status.PASS,"Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.log(Status.FAIL,"Test Failed");
		extentTest.log(Status.FAIL,result.getThrowable().getMessage());
		
		try {
			String img=BaseClass.captureScreen(result.getName());
			extentTest.addScreenCaptureFromPath(img);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.createNode(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.SKIP,"Test Skipped");
		extentTest.log(Status.SKIP,result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();

		/*
		 * try { URL url = new
		 * URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		 * 
		 * // Create the email message 
		 * ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("smtp.googlemail.com"); 
		 * email.setSmtpPort(465);
		 * email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com","password")); 
		 * email.setSSLOnConnect(true);
		 * email.setFrom("pavanoltraining@gmail.com"); //Sender
		 * email.setSubject("Test Results");
		 * email.setMsg("Please find Attached Report....");
		 * email.addTo("pavankumar.busyqa@gmail.com"); //Receiver 
		 * email.attach(url, "extent report", "please check report..."); 
		 * email.send(); // send the email 
		 * }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
		 
		  
		 
	}
	
	
	
	
	

	
}
