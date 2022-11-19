package com.mystore.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {
	WebDriver ldriver;
	
	public ShoppingCartPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="input[value=\'guest\']")
	@CacheLookup
	WebElement guestAccount;
	
	@FindBy(name="company")
	@CacheLookup
	WebElement company;
	
	@FindBy(id="input-payment-email")
	@CacheLookup
	WebElement emailAdd;
	
	@FindBy(name="address_1")
	@CacheLookup
	WebElement address_1;
	
	@FindBy(name="address_2")
	@CacheLookup
	WebElement address_2;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name="postcode")
	@CacheLookup
	WebElement postcode;
	
	@FindBy(id="input-payment-country")
	@CacheLookup
	WebElement country;
	
	@FindBy(id="input-payment-zone")
	@CacheLookup
	WebElement state;
	
	@FindBy(id="button-account")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(id="button-guest")
	@CacheLookup
	WebElement btnContinue1;
	
	@FindBy(id="button-shipping-method")
	@CacheLookup
	WebElement btnMethodContinue;
	
	@FindBy(id="button-payment-method")
	@CacheLookup
	WebElement btnPaymentContinue;
	
	@FindBy(how = How.CSS, using = "input[type='checkbox']")
	@CacheLookup
	WebElement checkbox;
	
	@FindBy(how = How.NAME, using = "agree")
	@CacheLookup
	WebElement checkbox1;
	
	@FindBy(id="button-confirm")
	@CacheLookup
	WebElement btnConfirm;
	
	@FindBy(id="button-payment-address")
	@CacheLookup
	WebElement btnPaymentConti;
	
	@FindBy(id="button-shipping-address")
	@CacheLookup
	WebElement btnDeliveryConti;
	
	public void clickGuest() {
		guestAccount.click();
	}
	
	public void setEmail(String emailadd) {
		emailAdd.click();
		emailAdd.sendKeys(emailadd);
	}
	
	public void setCompany(String comName) {
		company.click();
		company.sendKeys(comName);
	}
	
	public void setAddress1(String address1) {
		address_1.click();
		address_1.sendKeys(address1);
	}
	
	public void setAddress2(String address2) {
		address_2.click();
		address_2.sendKeys(address2);
	}
	
	public void setCity(String cityName) {
		city.click();
		city.sendKeys(cityName);
	}
	
	public void setPostcode(String post) {
		postcode.click();
		postcode.sendKeys(post);
	}
	
	public void selectCountry() {
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText("Canada");
	}
	
	public void selectState() {
		Select dropdown = new Select(state);
		dropdown.selectByVisibleText("Ontario");
	}
	
	public boolean validationCheckBox() {
		if(checkbox.isSelected()) {
			return true;
		}else {
			checkbox.click();	
			}
		boolean validCheck = checkbox.isSelected();
		return validCheck;
	}
	
	public boolean validationCheckBox1() {
		if(checkbox1.isSelected()) {
			return true;
		}else {
			checkbox1.click();	
			}
		boolean validCheck = checkbox.isSelected();
		return validCheck;
	}
	
	public void scrollElement() throws InterruptedException {
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", btnContinue);
		Thread.sleep(500); 
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public void clickContinue1() {
		btnContinue1.click();
	}
	
	public void clickContinue2() {
		btnMethodContinue.click();
	}
	
	public void clickContinue3() {
		btnPaymentContinue.click();
	}
	
	public void clickDeliveryDetail() {
		btnDeliveryConti.click();
	}
	
	public void clickPaymentDetail() {
		btnPaymentConti.click();
	}
	
	@FindBy(xpath="//*[@id=\'collapse-checkout-confirm\']/div/div[1]/table/tbody/tr/td[3]")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(xpath="//*[@id=\'collapse-checkout-confirm\']/div/div[1]/table/tbody/tr/td[4]")
	@CacheLookup
	WebElement unitPrice;
	
	@FindBy(xpath="//*[@id=\'collapse-checkout-confirm\']/div/div[1]/table/tbody/tr/td[5]")
	@CacheLookup
	WebElement totalPrice;
	
	@FindBy(xpath="//*[@id=\'collapse-checkout-confirm\']/div/div[1]/table/tfoot/tr[2]/td[2]")
	@CacheLookup
	WebElement tax;
	
	@FindBy(xpath="//*[@id=\'collapse-checkout-confirm\']/div/div[1]/table/tfoot/tr[3]/td[2]")
	@CacheLookup
	WebElement finalPrice;
	
	public boolean validateOrder() {
		int qnt = Integer.parseInt(quantity.getText());
		float uPrice = Float.parseFloat(unitPrice.getText().replace("$", ""));
		float sPrice = Float.parseFloat(tax.getText().replace("$", ""));
		float tPrice = qnt*uPrice+sPrice; 
		float fPrice = Float.parseFloat(finalPrice.getText().replace("$", ""));
		
		
		System.out.println(tPrice);
		System.out.println(fPrice);
		return tPrice == fPrice;
	}
	
	public void clickConfirm() {
		btnConfirm.click();
	}
}
