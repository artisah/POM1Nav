package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	public static String highlight;
	
	/**
	 * This method is used to intilaized the driver using given browser name
	 * @param prop
	 * @return this method returns webdriver
	 */
	public WebDriver initilizeDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		String url = prop.getProperty("url").trim();
		
	//	highlight = prop.getProperty("highlight").trim();
		
		System.out.println("browsername is: " + browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
		//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			
		}
		else {
			System.out.println("Please pass the right browser name: " + browserName);
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	
	/**
	 * This method is used to initilized the properties
	 * @return this returns properties class reference
	 */
	public Properties initilizeProperties(){
		prop = new Properties();
		try {
			// use "." before path of file to access in current directory
			FileInputStream fs = new FileInputStream("./src/test/resources/config/config.properties");
		    prop.load(fs);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
