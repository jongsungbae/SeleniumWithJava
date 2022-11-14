package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="search")
	@CacheLookup
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	@CacheLookup
	WebElement searchBtn;
	
	@FindBy(linkText="My Account")
	@CacheLookup
	WebElement myAccountBtn;
	
	@FindBy(linkText="Login")
	@CacheLookup
	WebElement loginBtn;

	
	public boolean indexValidate() {
		searchBox.isDisplayed();
		searchBtn.isEnabled();
		return true;
	}
	
	public void txtSearchBox(String txtSearch) {
		searchBox.sendKeys(txtSearch);
	}
	
	public void searchBtn() {
		searchBtn.click();
	}
	
	public void loginBtn() {
		myAccountBtn.click();
		loginBtn.click();
		
	}
	
}
