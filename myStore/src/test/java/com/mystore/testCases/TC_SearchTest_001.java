package com.mystore.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;

public class TC_SearchTest_001 extends baseClass {
	
	public String searchItem = readconfig.getSearchItem();
	
	@Test
	public void searchTest() throws IOException{
		IndexPage indexPage = new IndexPage(driver);
		SearchResultPage searchPage = new SearchResultPage(driver);
		
		// search using search box
		indexPage.txtSearchBox(searchItem);
		indexPage.searchBtn();
		
		Assert.assertTrue(searchPage.validateSearchResult()); 
		logger.info("successfully search");
		
		// search using menu
		indexPage.clickmenu();
		logger.info("click the menu");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='iPhone']")));
		logger.info("explicit wait - wait for the image to be click-able");
		searchPage.clickiPhone();
		logger.info("item click success");
	}

}
