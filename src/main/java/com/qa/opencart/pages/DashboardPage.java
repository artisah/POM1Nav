package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class DashboardPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header =  By.cssSelector("nav > label.logo > div > a > div > p");
//	private By sections = By.cssSelector("div#content h2");
	private By logoutLink = By.cssSelector(" ul > li:nth-child(5) > button");
	private By serachBox = By.name("search");
//	private By searchIcon = By.xpath("//div[@id = 'search']//button");
	
	
	//Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	public String getAccountsPageTitle() {
		System.out.println("iinside title");
		return eleUtil.doGetPageTitleIs(Constants.ACCOUNTS_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	
	public String getAccountsPageUrl() {
		return eleUtil.waitForUrlContains(Constants.ACCOUNTS_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	
	public String getAccountsPageHeader() {
		return eleUtil.doGetText(header);
	}
	
	
	public boolean isLogOutLinkExists() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	
	public boolean logout() {
		if (isLogOutLinkExists()) {
			eleUtil.doClick(logoutLink);
			return true;
		}
		return false;
		
	}
	
	public List<String> getAccountsPageSctions() {
		List<WebElement> AccountPageSection = eleUtil.waitForElementsVisible(serachBox, 10);
		List<String> sectionTextList = new ArrayList<String>();
		for (WebElement e : AccountPageSection) {
			String sectionText = e.getText();
			sectionTextList.add(sectionText);		
		}	
		return sectionTextList;	
	}
	
	
	public boolean isSearchTextBoxexists() {
		return eleUtil.doIsDisplayed(serachBox);
		
	}
	
	
//	public void doSearch(String productName) {
//		if(isSearchTextBoxexists()) {
//			eleUtil.doSendKeys(serachBox, productName);
//			eleUtil.doClick(searchIcon);	
//		}
//	}

}