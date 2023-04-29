package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constants;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	
	// Intialized at class level, so that can be accessed from LoginPageTest, when extends by BaseTest
	LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initilizeProperties();
		driver = df.initilizeDriver(prop);
		loginPage = new LoginPage(driver);	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}
