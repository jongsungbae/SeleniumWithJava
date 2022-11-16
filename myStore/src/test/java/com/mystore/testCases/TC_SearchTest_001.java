package com.mystore.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.ProductPage;
import com.mystore.pageObjects.SearchResultPage;

public class TC_SearchTest_001 extends baseClass {
	
	public String searchItem = readconfig.getSearchItem();
	
	@Test
	public void searchTest() throws IOException, InterruptedException{
		IndexPage indexPage = new IndexPage(driver);
		SearchResultPage searchPage = new SearchResultPage(driver);
		ProductPage productPage = new ProductPage(driver);
		
	    
		// search using search box
		indexPage.txtSearchBox(searchItem);
		indexPage.searchBtn();
		
		Assert.assertTrue(searchPage.validateSearchResult()); 
		logger.info("successfully search");
		
		// search iPhone
		indexPage.clickPhoneMenu();
		logger.info("click the menu");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='iPhone']")));
		logger.info("explicit wait - wait for the image to be click-able");
		searchPage.clickiPhone();
		logger.info("item click success");
		
		// Product page
		productPage.clickfirstImage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Next (Right arrow key)']")));
		
		productPage.popupImg();
		captureScreen(driver, "popup_img");
		logger.info("popup capture success");
		productPage.closePopup();
		
		productPage.inputQty("2");
		logger.info("input QTY");
		
		productPage.addToCart();
		
		String expectedMessage = "Success: You have added ";
		Assert.assertTrue(productPage.getAddCartText().contains(expectedMessage));
		logger.info("Success - add cart");
		
		
		// search Laptop
		indexPage.clickLaptopMenu();
		String expectedTitle = "Laptops & Notebooks";
		Assert.assertEquals(searchPage.getLaptopTitle(), expectedTitle);
		logger.info("Success - Move to laptop menu");
		
		searchPage.clickLaptop();
		logger.info("click laptop");
		Thread.sleep(1000);
		productPage.scrollElement();
		logger.info("scroll success");
		Thread.sleep(1000);
		productPage.calender();
		logger.info("choose calender");
		
		Thread.sleep(3000);
		productPage.inputQty("2");
		logger.info("input QTY");
		
		productPage.addToCart();
		
		Assert.assertTrue(productPage.getAddCartText().contains(expectedMessage));
		logger.info("Success - add cart");
		
	}

}
