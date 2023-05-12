package com.qa.opencart.tests;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class DashboardPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test
//	public void accPageTitleTest() {
//		String actTitle = accPage.getAccountsPageTitle();
//		System.out.println("Acc page title : " + actTitle);
//		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITLE);
//	}

	@Test
	public void accPageUrlTest() {
		String actUrl = accPage.getAccountsPageUrl();
		System.out.println("Acc page url : " + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
	}
	
//	@Test
//	public void accPageTitleTest() {
//		String actualAccountsPageTitle = accPage.getAccountsPageTitle();
//		System.out.println("Account page Title is " + actualAccountsPageTitle);
//		Assert.assertEquals(actualAccountsPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
//		
//	}
	
//	@Test
//	public void accPageUrlTest() {
//		String actualAccountsPageTitle = accPage.getAccountsPageUrl();
//		//System.out.println("Account page url is " +actualAccountsPageTitle);
//		Assert.assertTrue(actualAccountsPageTitle.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
//		
//	}
//	
//	@Test
//	public void accPageHeaderTest() {
//		String header = accPage.getAccountsPageHeader();
//		System.out.println("Account page Header is " + header);
//		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER);
//	}
//	
//	@Test
//	public void logoutLinkExistTest( ) {
//		Assert.assertTrue(accPage.isLogOutLinkExists());	
//	}
//	
//	
//	@Test
//	public void searchBoxExistsTest() {
//		Assert.assertTrue(accPage.isSearchTextBoxexists());
//		
//	}
//	
//	@Test
//	public void accPageSectionsTest() {
//		List<String> accPageSectionsList = accPage.getAccountsPageSctions();
//		System.out.println("Accounys page sections are : " + accPageSectionsList);
//		Assert.assertEquals(accPageSectionsList, Constants.ACCOUNTS_PAGE_SECTIONS_LIST);	
//		
//	}

}
