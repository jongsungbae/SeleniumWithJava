package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(className = "image")
	@CacheLookup
	WebElement searchImg;
	
	@FindBy(css = "img[title='iPhone']")
	@CacheLookup
	WebElement clickiPhone;
	
	public boolean validateSearchResult() {
		searchImg.isDisplayed();
		return true;
	}
	
	public void clickiPhone() {
		clickiPhone.click();
	}

}
