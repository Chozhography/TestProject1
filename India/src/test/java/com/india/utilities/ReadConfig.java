package com.india.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public String ReadConfig() {
		
		
		File src = new File ("./Configuration files/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		return null;}
		
		public String getApplicationURL()
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		public String getUsername() {
			String username=pro.getProperty("username");
			return username;
		}
		
		
		
		public String getPassword() {
			
			String password=pro.getProperty("password");
			return password;		}
		
		public String getChromepath(){
			String chromepath=pro.getProperty("chromepath"); return chromepath;
		}
		
	
	
}

