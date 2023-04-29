package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class loginPageTest extends BaseTest {
	
	@Test
	public void dloginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title: " + actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);		
	}
	
	@Test
	public void LoginPageUrlTest() {
		String actualUrl = loginPage.getLoginPageUrl();
		System.out.println("Login Page Title: " + actualUrl);
		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));	
	}
	
	@Test
	public void ForgotPwdLinkExistTest( ) {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());	
	}
	
	@Test
	public void doLoginTest() {
		String username = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		loginPage.doLogin(username, pwd);			
	}

}
