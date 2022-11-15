package com.mystore.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\'content\']//li[1]")
	@CacheLookup
	WebElement firstImg;
	
	@FindBy(css ="button[title='Previous (Left arrow key)']")
	@CacheLookup
	WebElement nextArrow;
	
	@FindBy(css ="button[title='Next (Right arrow key)']")
	@CacheLookup
	WebElement previousArrow;
	
	@FindBy(css ="button[title='Close (Esc)']")
	@CacheLookup
	WebElement closeBtn;
	
	@FindBy(name = "quantity")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(id = "button-cart")
	@CacheLookup
	WebElement addCart;
	
	@FindBy(css = "div[class=\'alert alert-success alert-dismissible\']")
	@CacheLookup
	WebElement addCartText;
	
	@FindBy(xpath="//*[@id=\'product\']/div[1]/div/span/button")
	@CacheLookup
	WebElement calender;
	
	@FindBy(xpath="/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[2]")
	@CacheLookup
	WebElement calenderMonth;
	
	@FindBy(xpath="/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]")
	@CacheLookup
	WebElement nextMonthBtn;
	
	@FindBy(xpath="//td[text()='25']")
	@CacheLookup
	WebElement calenderDay;
	public void clickfirstImage() {
		firstImg.click();
	}
	
	public void popupImg() throws InterruptedException {
		for(int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			nextArrow.click();
		}
	}
	
	public void closePopup() {
		closeBtn.click();
	}
	
	public void scrollElement() throws InterruptedException {
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", addCart);
		Thread.sleep(500); 
	}
	
	public void calender() throws InterruptedException {
		calender.click();
		Thread.sleep(1000);
		
		String wantedDate = "December 2011";
		while(true) {
			nextMonthBtn.click();
			if(calenderMonth.getText().equals(wantedDate)) {
				break;
			}
		}	
		calenderDay.click();
	}
	
	
	public void inputQty(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void addToCart() {
		addCart.click();
	}
	
	public String getAddCartText() {
		String actualMessage = addCartText.getText();
		return actualMessage;
	}
		
	
	

}
