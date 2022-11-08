package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		logger.info("Login success");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		addcust.custName("Jay");
		addcust.custgender();
		addcust.custdob("11", "11", "1999");
		Thread.sleep(3000);
		addcust.custaddress("Toronto");
		addcust.custcity("Toronto");
		addcust.custstate("ON");
		addcust.custpinno(3000123);
		addcust.custtelephoneno("123456789");
		
		String randomEmail = randomstring() + "@gmail.com";
		addcust.custemail(randomEmail);
		
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		
		logger.info("Validation started...");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}else {
			logger.info("test case failed...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}
	}
	
	

}
