package com.apex.samples;

public interface EcommerceLoginConstant {
	
	public final static String SeleniumIEDriverPath64 = "C:\\Working\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe";
	public final static String SeleniumIEDriverPath32 = "C:\\Working\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";

	//Locators
	String LOGIN_LINK_LOCATOR = "Login";
	String SIGNUP_LINK_LOCATOR = "SignUp";
	String HOME_LINK_LOCATOR = "http://ecommerce.saipratap.net/index.php";
	String LOGIN_FAILURE_LINK_LOCATOR = "http://ecommerce.saipratap.net/customerlogin.php?msg=lnvalid";
	
	//Test data
	String TEST2_EMAIL_ID = "test2@gmail.com";
	String CONFIRMATION_NAME_LOCATOR = "cpassword";
	String PASSWORD_NAME_LOCATOR = "password";
	String TELEPHONE1_NAME_LOCATOR = "phone";
	String TELEPHONE2_NAME_LOCATOR = "fax";
	String CITY_NAME_LOCATOR = "city";
	String POSTCODE_NAME_LOCATOR = "postcode";
	String HOUSE_NUMBER_LOCATOR = "houseno";
	String STREET_NAME_LOCATOR = "add1";
	String EMAIL_NAME_LOCATOR = "email";
	String DOB_DAYOFBIRTH_LOCATOR = "day";
	String DOB_MONTHOFBIRTH_LOCATOR = "month";
	String DOB_YEAROFBIRTH_LOCATOR = "year";
	String LASTNAME_NAME_LOCATOR = "lname";
	String FIRSTNAME_NAME_LOCATOR = "fname";
	String STATE_NAME_LOCATOR = "state";
	String COUNTRY_NAME_LOCATOR = "country";
	String TERMS_LOCATOR = "terms";
	
	//newsletter
	String NEWS_LETTER_LOCATOR = "newsletter";
	
	// Action
	String ACTION_LOCATOR = "Submit";
	
	//message
	String MESSAGE_LOCATOR = "Thank you for signing up. Your account is now created and you can log in by clicking the ACCOUNT button in the main menu above.";

	String ALREADY_EXIST_MESSAGE_LOCATOR = "This email address is already registered.";
	
	//timeouts

}
