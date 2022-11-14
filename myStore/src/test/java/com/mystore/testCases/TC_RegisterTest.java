package com.mystore.testCases;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.RegisterPage;

@Test
public class TC_RegisterTest extends baseClass {
	
	public void registerTest() throws InterruptedException, IOException{
		IndexPage indexPage = new IndexPage(driver);
		RegisterPage registerPage = new RegisterPage(driver);
		
		indexPage.registerBtn();
		Thread.sleep(2000);
		
		Random random = new Random();
		Faker faker = new Faker();
		
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String email = "test_00" + random.nextInt(20) + "gmail.com";
		String tele = faker.phoneNumber().cellPhone();
		
		
		registerPage.setFirstName(fname);
		registerPage.setLastName(lname);
		registerPage.setEmail(email);
		registerPage.setTel(tele);
		registerPage.setPwd("test123!");
		registerPage.confirmPwd("test123!");
		registerPage.checkBox();
		registerPage.submitBtn();
		
	}

}
