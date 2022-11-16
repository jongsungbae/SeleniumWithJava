package com.mystore.testCases;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.mystore.pageObjects.ConfirmPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.ProductPage;
import com.mystore.pageObjects.RegisterPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShoppingCartPage;

@Test
public class TC_ShoppingCart_001 extends baseClass{
	
	public String searchItem = readconfig.getSearchItem();
	
	public void shoppingCartTest() throws IOException, InterruptedException {
		IndexPage indexPage = new IndexPage(driver);
		SearchResultPage searchPage = new SearchResultPage(driver);
		ProductPage productPage = new ProductPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);	
		RegisterPage registerPage = new RegisterPage(driver);
		ConfirmPage confirmPage = new ConfirmPage(driver);
		
		// search Laptop
		indexPage.clickLaptopMenu();
		String expectedTitle = "Laptops & Notebooks";
		Assert.assertEquals(searchPage.getLaptopTitle(), expectedTitle);
		logger.info("Success - Move to laptop menu");
				
		searchPage.clickLaptop();
		logger.info("click laptop");
		//productPage.scrollElement();
		//logger.info("scroll success");
		productPage.calender();
		logger.info("choose calender");
		
		Thread.sleep(3000);
		productPage.inputQty("1");
		logger.info("input QTY");
		Thread.sleep(1000);
		productPage.addToCart();
		
		String expectedMessage = "Success: You have added ";		
		Assert.assertTrue(productPage.getAddCartText().contains(expectedMessage));
		logger.info("Success - add cart");
		
		Thread.sleep(1000);
		productPage.clickCart();
		productPage.clickCheckout();
		Thread.sleep(1000);
		
		shoppingCartPage.clickGuest();
		shoppingCartPage.clickContinue();
		
		// Billing Details
		shoppingCartPage.scrollElement();
		logger.info("screen success");
		
		Faker faker = new Faker();		
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String tele = faker.phoneNumber().cellPhone();
		String company = faker.company().name();
		String address = faker.address().fullAddress();
		String city = faker.address().city();
		String postCode = faker.address().zipCode();
		
		registerPage.setFirstName(fname);
		registerPage.setLastName(lname);
		shoppingCartPage.setEmail(email);
		registerPage.setTel(tele);
		
		logger.info("Input personal details");
		
		shoppingCartPage.setCompany(company);
		shoppingCartPage.setAddress1(address);
		shoppingCartPage.setCity(city);
		shoppingCartPage.setPostcode(postCode);
		shoppingCartPage.selectCountry();
		shoppingCartPage.selectState();
		logger.info("Input address details");
		
		Assert.assertTrue(shoppingCartPage.validationCheckBox());
		logger.info("checkbox is checked");
		
		Thread.sleep(1000);
		shoppingCartPage.clickContinue1();
		logger.info("Success - Billing Details");
		
		shoppingCartPage.clickContinue2();
		logger.info("Success - Delevery Method");
		
		// Payment Method
		Assert.assertTrue(shoppingCartPage.validationCheckBox1());
		Thread.sleep(2000);
		shoppingCartPage.clickContinue3();
		logger.info("Success - Payment Method");
		
		Thread.sleep(2000);
		// Confirm order
		Assert.assertTrue(shoppingCartPage.validateOrder());
		logger.info("Validate Price");
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
}
