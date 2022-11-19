package com.mystore.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.mystore.pageObjects.ConfirmPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.ProductPage;
import com.mystore.pageObjects.RegisterPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShoppingCartPage;
import com.mystore.utilities.XLUtils;



public class TC_UserAcceptance extends baseClass {
	
	@Test(dataProvider="LoginData")
	public void userStory(String user, String pwd) throws IOException, InterruptedException {
		IndexPage indexPage = new IndexPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		SearchResultPage searchPage = new SearchResultPage(driver);
		ProductPage productPage = new ProductPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);	
		RegisterPage registerPage = new RegisterPage(driver);
		ConfirmPage confirmPage = new ConfirmPage(driver);
		
		// search Laptop
		indexPage.clickLaptopMenu();
		logger.info("Success - Move to laptop & Notebooks");
		searchPage.clickLaptop();
		logger.info("click HP3065 Labtop");
		
		// Product Page
		productPage.calender();
		logger.info("choose calender");
		Thread.sleep(2000);
		productPage.inputQty("1");
		logger.info("input QTY");
		Thread.sleep(1000);
		productPage.addToCart();
		logger.info("Success - Add to Cart");
		productPage.clickCart();
		productPage.clickCheckout();
		Thread.sleep(1000);
		logger.info("Move to Checkout Page");
		
		// Checkout Page
		loginPage.setUserName(user);
		logger.info("input username");
		loginPage.setPassword(pwd);
		logger.info("input password");
		
		loginPage.loginClick();
		logger.info("Success - step1");

		// Billing Details
		shoppingCartPage.clickPaymentDetail();
		logger.info("Success - Billing Details");
		
		shoppingCartPage.clickDeliveryDetail();
		logger.info("Success - Delivery Details");
				
		shoppingCartPage.clickContinue2();
		logger.info("Success - Delevery Method");	

		Assert.assertTrue(shoppingCartPage.validationCheckBox1());
		Thread.sleep(1000);
		shoppingCartPage.clickContinue3();
		logger.info("Success - Payment Method");
		Thread.sleep(2000);

		shoppingCartPage.clickConfirm();
		Thread.sleep(2000);
				
		// Final Page
		if(confirmPage.validConfirmText()) {
			Assert.assertTrue(true);
			logger.info("Order success");
		}else {
			captureScreen(driver, "final page fail");
			Assert.assertTrue(false);
			logger.info("Order confirm failed");
		}
				
		confirmPage.clickContinue();

	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
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