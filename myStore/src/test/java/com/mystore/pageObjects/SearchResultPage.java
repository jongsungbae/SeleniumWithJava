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
	
	@FindBy(xpath = "//h2[text()='Laptops & Notebooks']")
	@CacheLookup
	WebElement laptopTitle;
	
	@FindBy(linkText = "HP LP3065")
	@CacheLookup
	WebElement laptop;
	
	public boolean validateSearchResult() {
		searchImg.isDisplayed();
		return true;
	}
	
	public void clickiPhone() {
		clickiPhone.click();
	}
	
	public String getLaptopTitle() {
		String actualTitle = laptopTitle.getText();
		return actualTitle;
	}

	public void clickLaptop() {
		laptop.click();
	}
}
