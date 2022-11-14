package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="email")
	@CacheLookup
	WebElement loginEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(css = "input[value='Login']")
	@CacheLookup
	WebElement loginBtn;
	
	public void setUserName(String uname) {
		loginEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		loginPassword.sendKeys(pwd);
	}
	
	public void loginClick() {
		loginBtn.click();
	}

}
