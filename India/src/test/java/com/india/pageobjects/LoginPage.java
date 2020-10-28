package com.india.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver adriver;
	
	public LoginPage(WebDriver bdriver){
		
		adriver=bdriver;
		PageFactory.initElements(bdriver, this);
	}
	
	
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	
	public void setusername(String username) {
		
		txtUserName.sendKeys(username);
		
	}
	public void setpassword(String password) {
		
		txtPassword.sendKeys(password);
		
	}
	
	public void clicksubmit() {
		
		btnLogin.click();
		
	}
	
	

}
