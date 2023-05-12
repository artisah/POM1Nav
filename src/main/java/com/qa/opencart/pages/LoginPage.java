package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

//import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By emailID = By.id("userEmail");
	private By password = By.id("userPassword");
	private By loginBtn = By.id("login");
	private By forgotPwdLink = By.linkText("Forgot password?");
	private By registerLink = By.linkText("Register");
	
	
	
	
	//2. Page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3 Page Actions/methods:
	public String getLoginPageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getLoginPageUrl() {
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public DashboardPage doLogin(String username, String pwd){
		eleUtil.doSendKeys(emailID, username);
		eleUtil.doSendKeys(password, pwd);
		System.out.println("username is:  " + username  + "   password is:    " + pwd);
		eleUtil.doClick(loginBtn);
	    return new DashboardPage(driver);
		
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}




}


//package com.qa.opencart.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import com.qa.opencart.utils.Constants;
//import com.qa.opencart.utils.ElementUtil;
//
//public class LoginPage {
//	
//	private WebDriver driver;
//	private ElementUtil eleUtil;
//	
//	//Encapsulation
//	
//	//1. Private By locator
//	private By emailID = By.id("input-email");
//	private By password = By.id("input-password");
//	//private By loginBtn = By.xpath("//button[text() = 'Login']");
//	private By loginBtn = By.cssSelector("#form-login > button");
//	private By forgotPwdLink = By.linkText("Forgotten Password");
//	
//	
//	//2. Page constructor
//	public LoginPage(WebDriver driver) {
//		this.driver = driver;
//		eleUtil = new ElementUtil(driver);
//	}
//	
//	//3 Page Actions/methods:
//	public String getLoginPageTitle() {
//		return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
//	}
//	
//	public String getLoginPageUrl() {
//		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
//	}
//	
//	public boolean isForgotPwdLinkExist() {
//		return eleUtil.doIsDisplayed(forgotPwdLink);
//	}
//	
//	public AccountsPage doLogin(String username, String pwd) throws InterruptedException {
//		eleUtil.doSendKeys(emailID, username);
//		eleUtil.doSendKeys(password, pwd);
//		System.out.println("username is:  " + username  + "   password is:    " + pwd);
//		Thread.sleep(5000);
//		eleUtil.doClick(loginBtn);
//		Thread.sleep(5000);
//	    return new AccountsPage(driver);
//		
//	}
//
//}
