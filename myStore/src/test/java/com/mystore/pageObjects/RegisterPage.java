package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
WebDriver ldriver;
	
	public RegisterPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="firstname")
	@CacheLookup
	WebElement fname;
	
	@FindBy(name="lastname")
	@CacheLookup
	WebElement lname;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name="telephone")
	@CacheLookup
	WebElement tel;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(name="confirm")
	@CacheLookup
	WebElement confirmpwd;
	
	@FindBy(name="agree")
	@CacheLookup
	WebElement checkbox;
	
	@FindBy(css="input[value='Continue']")
	@CacheLookup
	WebElement continueBtn;
	
	public void setFirstName(String firstName) {
		fname.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lname.sendKeys(lastName);
	}
	
	public void setEmail(String txtemail) {
		email.sendKeys(txtemail);
	}
	
	public void setTel(String phone) {
		tel.sendKeys(phone);
	}
	
	public void setPwd(String txtPwd) {
		pwd.sendKeys(txtPwd);
	}
	
	public void confirmPwd(String cfPwd) {
		confirmpwd.sendKeys(cfPwd);
	}
	
	public void checkBox() {
		if(!checkbox.isSelected()) {
			checkbox.click();
		}		
	}
	
	public void submitBtn() {
		continueBtn.click();
	}
}
