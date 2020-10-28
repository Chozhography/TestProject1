package com.india.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.india.pageobjects.LoginPage;

public class Tc_LoginTest_001 extends BaseClass{

	
	
	@Test
	public void loginTest() throws IOException {
		
		driver.get(baseURL);
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("username is entered");
		lp.setpassword(password);
		logger.info("password is entered");
		lp.clicksubmit();
		logger.info("submit button is clicked");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			
			
			Assert.assertTrue(true);
			logger.info("Login test is passed");
		}
	
		else
		{
			CaptureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test is failed");}
	
		
	
	}
}
