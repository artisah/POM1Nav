package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void registerPageSetup( ) {
		registerPage = loginPage.navigateToRegisterPage();				
	}
	
	public String getRandomEmailId() {
		Random randomGen = new Random();
		String email = "testautomationmay" + randomGen.nextInt(1000) + "@gmail.com";
		System.out.println("email id generated is " + email);
		return email;
	}
	
	@DataProvider
	public Object[][] getRegistrationData() {
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
		
	}
	
	@Test
	public void registerPageUrlTest() {
		String actUrl = registerPage.getrRegisterPageUrl();
		System.out.println("Register page url : " + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.REGISTER_PAGE_URL_FRACTION));
	}
	
	
	// Do not add email in excel sheet data, as duplicate email id will not be registered, so created a method to generate random email ids.
	@Test(dataProvider = "getRegistrationData")
	public void accountRegisterationTest(String firstname, String lastName, String phoneNumber, String password, String occupation, String gender ) {
		boolean successmsgStatus = registerPage.accountRegisteration(firstname,lastName,getRandomEmailId(),phoneNumber, password , occupation, gender);
		Assert.assertTrue(successmsgStatus);
	}

}
