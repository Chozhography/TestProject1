package com.india.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.india.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	
	
ExtentHtmlReporter htmlReporter;
String method;

@BeforeTest

public void generatereport() {
	
	htmlReporter = new ExtentHtmlReporter("test-output/AutomationReport.html");
	
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	
}


@BeforeMethod
public void setmethodName() {
	
	parentTest = extent.createTest(method.getName());
}
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
	driver = new ChromeDriver();
	
	logger=Logger.getLogger("India");
	PropertyConfigurator.configure("log4j.prperties");
	
	
	}
@Test
public void test(){
	
	driver.get("https://www.mercurytours.com");}
	
	      @AfterClass
          public void tearDown() {
        	  
        	  driver.quit();
        	  extent.flush();
          }

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

