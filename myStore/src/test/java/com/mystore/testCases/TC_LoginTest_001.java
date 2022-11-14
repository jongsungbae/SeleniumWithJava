package com.mystore.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.utilities.XLUtils;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

public class TC_LoginTest_001 extends baseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException{
		
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		indexPage.loginBtn();
		
		loginPage.setUserName(user);
		logger.info("input username");
		loginPage.setPassword(pwd);
		logger.info("input password");
		
		loginPage.loginClick();
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
//		String path = System.getProperty("user.dir") + "/src/test/java/com/mystore/testData/LoginData.xlsx";
		String path = System.getProperty("user.dir") + readconfig.getLoginData();
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
	return logindata;	
	}

}
