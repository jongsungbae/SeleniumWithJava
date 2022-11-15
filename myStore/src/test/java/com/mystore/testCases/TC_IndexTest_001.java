package com.mystore.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import com.mystore.pageObjects.IndexPage;

public class TC_IndexTest_001 extends baseClass{
	
	
	@Test
	public void indexTest() throws IOException{
		
		IndexPage indexPage = new IndexPage(driver);
		
		if(driver.getTitle().equals("Your Store")) {
			Assert.assertTrue(true);
			logger.info("Index Page is displayed");
		}else {
			captureScreen(driver, "IndexPageTest");
			Assert.assertTrue(false);
			logger.info("index Page failed");
		}
		
		Assert.assertTrue(indexPage.indexValidate());
		
	}
}
