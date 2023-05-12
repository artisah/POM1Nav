package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName =  By.id("firstName");
	private By lastName = By.id("lastName");
	private By emailId = By.id("userEmail");
	private By phoneNumber = By.id("userMobile");
	private By password = By.id("userPassword");
	private By confirmPassword = By.id("confirmPassword");
	private By selectOccupation = By.cssSelector("form > div:nth-child(3) > div:nth-child(1) > select");
	private By genderMaleRadioButton = By.xpath("//form/div[3]/div[2]/label[2]/input");
	private By genderFemaleRadioButton = By.xpath("//form/div[3]/div[2]/label[3]/input");
	private By eigteenYesrOldCheckbox = By.cssSelector(" form > div:nth-child(5) > div.col-md-1 > input");
	private By registerBtn =  By.id("login");
	private By accountCreatedSuccessMsg = By.xpath("/html/body/app-root/app-register/div[1]/section[2]/div/div[2]/h1");
	private By loginButtonAfterAccountCreation = By.xpath("/html/body/app-root/app-register/div[1]/section[2]/div/div[2]/button");
	//private By registerLink = By.linkText("Register");
	private By loginPageRegisterLink = By.linkText("Register here");
	
	//Constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String getrRegisterPageUrl() {
		return eleUtil.waitForUrlContains(Constants.REGISTER_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean accountRegisteration(String firstname, String lastName, String emailId, String phoneNumber, String password, String occupation, String gender) {
		
		eleUtil.doSendKeys(this.firstName, firstname);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.emailId, emailId);
		eleUtil.doSendKeys(this.phoneNumber, phoneNumber);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(confirmPassword, password);
		eleUtil.doSelectDropDownByVisibleText(selectOccupation, occupation);
		
		if (gender.equalsIgnoreCase("male")) {
			eleUtil.doClick(genderMaleRadioButton);
		}else if (gender.equalsIgnoreCase("female")) {
			eleUtil.doClick(genderFemaleRadioButton);
		}
		
		eleUtil.doClick(eigteenYesrOldCheckbox);
		eleUtil.doClick(registerBtn);
		
		String successMsg = eleUtil.doGetText(accountCreatedSuccessMsg);
		System.out.println(successMsg);
		
		if (successMsg.contains(Constants.REGISTER_PAGE_SUCCESS_MESSAGE)){
			eleUtil.doClick(loginButtonAfterAccountCreation);
			eleUtil.doClick(loginPageRegisterLink);
			return true;
			
		}
		return false;
		
	}
	

}
