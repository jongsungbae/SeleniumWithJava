package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
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
	
	public void txtSearchBox(String txtSearch) {
		searchBox.sendKeys(txtSearch);
	}
	
	public boolean searchBoxisVisible() {
		searchBox.isEnabled();
		return true;
	}
	
}
