package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void registerPageSetup( ) {
		registerPage = loginPage.navigateToRegisterPage();
				
	}
	
	@DataProvider
	public void getRegistrationData() {
		
	}
	
	@Test
	public void registerPageUrlTest() {
		String actUrl = registerPage.getrRegisterPageUrl();
		System.out.println("Register page url : " + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.REGISTER_PAGE_URL_FRACTION));
	}
	
	@Test
	public void accountRegisterationTest() {
		boolean successmsgStatus = registerPage.accountRegisteration("tesuser23", "lastname12", "testasd@gmail.com", "1234567898", "Selenium@123", "Student", "male");
		Assert.assertTrue(successmsgStatus, " Registeration is unsuccessfull");
	}

}
