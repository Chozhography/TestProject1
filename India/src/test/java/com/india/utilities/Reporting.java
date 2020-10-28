package com.india.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;

//Listerner class used to generate extent report






public class Reporting extends TestListenerAdapter{

	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentTest logger;
	
	
	public void setExtent() {
		
		String timestamp= new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timestamp+"html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
		
		
		extent=new ExtentReports();
		
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "Local");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester name", "Chozhan");
		extent.setSystemInfo("Browser name", "Chrome");
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");//Title of the Report
		htmlReporter.config().setReportName("Functional Report");//Name of the Report
		htmlReporter.config().setTheme(Theme.DARK);//
		
		
			}
	
	
	
	
	public void onTestSuccess(ITestResult tr)
	
	{
		
		logger =extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		
	}
		public void endReport() {
		
		
		extent.flush();
		
	}
	
	public void noCommerceTitleTest() {
		
		test=extent.createTest("noCommercerTitleTest");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "ecommerce demo");
		
	}
	
	public void noCommerceLogoTest() {
		
		test=extent.createTest("ecommerce");
		Boolean status=driver.findElement(By.xpath("")).isDisplayed();
		Assert.assertTrue(status);	
	}
	
	
	
	public void loginTest() {
		
		test=extent.createTest("noCommerceLogoTest");
		Assert.assertTrue(true);
	}
	
	public void tearDown(ITestResult result) {
		
		if (result.getStatus()== ITestResult.FAILURE) {
			test.log(Status.FAIL,"TEST CASE FAILED IS" + result.getName() ); // to add name in extent rteport
			test.log(Status.FAIL,"TEST CASE FAILED IS" + result.getThrowable() ); // to add error/exception to the extent report
			
			
			String screenshotpath=noCommerceLogoTest.getScreenshot(driver,result.getName());
			
			test.addScreenCaptureFromPath(screenshotpath);}
		
		else if 
		(result.getStatus()==ITestResult.SKIP) {
			
			test.log(Status.SKIP,"Test case SKIPPED IS" +result.getName());
		}
			
			
		else if 
		(result.getStatus()==ITestResult.SUCCESS) {
			
			test.log(Status.SKIP,"Test case PASSED IS" +result.getName());
		}
			
		}
		
		// to code for screenshot capture and go for source and final destination path
	
	public void CaptureScreenshot(WebDriver driver, String ScreenshotName) throws IOException{
		
		
		String dateName= new SimpleDateFormat("yyyyMMddmmss").format(new Date());
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		//after execution u could see an filed scrrenshot under src folder
		
		String Destination = System.getProperty("user.dir")+"/Screenshots"+ScreenshotName +dateName +".png";
		File finalDestination = new File(Destination);
		FileUtils.copyDirectory(source, finalDestination);
		
		
		
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
