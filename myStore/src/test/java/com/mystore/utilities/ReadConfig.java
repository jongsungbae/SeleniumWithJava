package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Eception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
	
	public String getSearchItem() {
		String searchText = pro.getProperty("searchItem");
		return searchText;
	}
	
	public String getEmail() {
		String email = pro.getProperty("username");
		return email;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getLoginData() {
		String loginDataPath = pro.getProperty("loginTestDataPath");
		return loginDataPath;
	}
}
