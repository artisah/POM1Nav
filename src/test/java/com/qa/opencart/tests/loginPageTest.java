
package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//
//import com.qa.opencart.listeners.AnnotationTransformer;
//import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;

//import io.qameta.allure.Description;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import io.qameta.allure.Story;

//@Epic("EPIC - 100 : Design Login page for Open Cart Application.....")
//@Story("US - 101: Login Page Features")
//@Listeners({AnnotationTransformer.class, TestAllureListener.class})
public class LoginPageTest extends BaseTest {

//	@Description("login Page Title Test")
//	@Severity(SeverityLevel.MINOR)
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

//	@Description("TC_01: login page url test")
//	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageURLTest() {
		String url = loginPage.getLoginPageUrl();
		System.out.println("Login page url : " + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
//	@Description("this is testing forgot pwd link on login page")
//	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
//	@Description("positive test case for login with correct credentials...")
//	@Severity(SeverityLevel.BLOCKER)
	@Test(description = "login test with correct username and password")
	public void loginTest() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(70000);
//		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	

}








//package com.qa.opencart.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.qa.opencart.utils.Constants;
//
//public class loginPageTest extends BaseTest {
//	
//	@Test
//	public void dloginPageTitleTest() {
//		String actualTitle = loginPage.getLoginPageTitle();
//		System.out.println("Login Page Title: " + actualTitle);
//		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);		
//	}
//	
//	@Test
//	public void loginPageUrlTest() {
//		String actualUrl = loginPage.getLoginPageUrl();
//		System.out.println("Login Page Title: " + actualUrl);
//		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));	
//	}
//	
//	@Test
//	public void forgotPwdLinkExistTest( ) {
//		Assert.assertTrue(loginPage.isForgotPwdLinkExist());	
//	}
//	
//	@Test
//	public void doLoginTest() throws InterruptedException {
//		String username = prop.getProperty("username");
//		String pwd = prop.getProperty("password");
//		
//		loginPage.doLogin(username, pwd);		
//		
//		Thread.sleep(5000);
//	}
//
//}
