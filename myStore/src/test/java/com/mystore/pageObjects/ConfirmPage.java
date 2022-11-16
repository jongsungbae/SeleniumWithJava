package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
	WebDriver ldriver;
	
	public ConfirmPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	@CacheLookup
	WebElement txtConfirm;
	
	@FindBy(linkText="Continue")
	@CacheLookup
	WebElement btnContinue;
	
	public boolean validConfirmText() {
		String txtOrder = txtConfirm.getText();
		String txtSuccess = "Your order has been placed!";
		return txtOrder.contains(txtSuccess);
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
}
