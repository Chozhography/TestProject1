package com.india.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.india.pageobjects.LoginPage;
import com.india.utilities.ExcelUtils;

public class Tc_Login_DDT_002 extends BaseClass{
@Test(dataProvider="LoginData")
	public void loginDDT() {
		
		LoginPage lp =new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clicksubmit();
	
if (isAlertPresent()==true)
{
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
	Assert.assertTrue(false);}
else
{
Assert.assertTrue(true);	
}}



public boolean isAlertPresent() {
	
	try {
		
		driver.switchTo().alert();
		return true;
	}
	catch (NoAlertPresentException e)
	{
	
	return false;
	}
	
	
}



@DataProvider(name="LoginData")
String[][] getData() throws IOException{

	String path ="path of the excel file";
	
	int rowcount=ExcelUtils.getRowCount(path, "Sheet1");
	int columncount=ExcelUtils.getCellCount(path,"Sheet1",1);
	
	String logindata[][]=new String[rowcount][columncount];


for(int i =1;i<=rowcount;i++)

{
for(int j=0;j<columncount;j++)	
{
logindata[i-1][j]=ExcelUtils.getcellData(path, "Sheet1", i,j);	

}
}

return logindata;

}


}
