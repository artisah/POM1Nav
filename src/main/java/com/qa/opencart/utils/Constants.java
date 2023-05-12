package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	//Advantage only one copy will be created bause of static
	public static final String LOGIN_PAGE_TITLE = "Not Found";
	public static final String LOGIN_PAGE_URL_FRACTION = "account/login";
	
	public static final String ACCOUNTS_PAGE_TITLE = "Not Found";
	public static final String ACCOUNTS_PAGE_URL_FRACTION = "account/account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final List<String> ACCOUNTS_PAGE_SECTIONS_LIST = 
			 Arrays.asList("My Account",
					 		"My Orders",
					 		"My Affiliate Account",
					 		"Newsletter");
	
	public static final int DEFAULT_TIME_OUT = 5;
	public static final String REGISTER_PAGE_URL_FRACTION = "auth/register";
	public static final String REGISTER_PAGE_SUCCESS_MESSAGE = "Account Created Successfully";
	
			

}
