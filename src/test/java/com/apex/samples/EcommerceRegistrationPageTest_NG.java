package com.apex.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.samples.core.ApexBaseChromeTest;

public class EcommerceRegistrationPageTest_NG extends ApexBaseChromeTest implements EcommerceLoginConstant {
	
	private String sUser = "shubh123@gmail.com";
	private String sPassword = "abcd123";

	@Test
	public void testwithHomePage() {
		driver.get(HOME_LINK_LOCATOR);
		
		String s = driver.getTitle();
		String s1 = driver.getCurrentUrl();
		
		if ((driver.getTitle().equals("Ez Shop Online")) && (driver.getCurrentUrl().equals("http://ecommerce.saipratap.net/thankyoumessage.php?msg=reg"))) {
			System.out.println("Customer Retrieving Home Page – Passed");
		} else {
			System.out.println("Customer Retrieving Home Page – Failed");
		}
		driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1");
	}

	@Test
	public void testwithRegistration() {
		driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1");
		driver.findElement(By.linkText(SIGNUP_LINK_LOCATOR)).click();

		driver.findElement(By.name(FIRSTNAME_NAME_LOCATOR)).sendKeys("Rahman");
		driver.findElement(By.name(LASTNAME_NAME_LOCATOR)).sendKeys("Mohommed");
		driver.findElement(By.name(DOB_DAYOFBIRTH_LOCATOR)).sendKeys("10");
		driver.findElement(By.name(DOB_MONTHOFBIRTH_LOCATOR)).sendKeys("10");
		driver.findElement(By.name(DOB_YEAROFBIRTH_LOCATOR)).sendKeys("1990");
		driver.findElement(By.name(EMAIL_NAME_LOCATOR)).sendKeys(sUser);

		driver.findElement(By.name(HOUSE_NUMBER_LOCATOR)).sendKeys("abcd xyz");
		driver.findElement(By.name(STREET_NAME_LOCATOR)).sendKeys("abcd xyz");
		driver.findElement(By.name(CITY_NAME_LOCATOR)).sendKeys("Hyderabad");
		driver.findElement(By.name(STATE_NAME_LOCATOR)).sendKeys("Telangana");
		driver.findElement(By.name(COUNTRY_NAME_LOCATOR)).clear();
		driver.findElement(By.name(COUNTRY_NAME_LOCATOR)).sendKeys("India");
		driver.findElement(By.name(POSTCODE_NAME_LOCATOR)).sendKeys("12345");

		driver.findElement(By.name(TELEPHONE1_NAME_LOCATOR)).sendKeys("9234565453");
		driver.findElement(By.name(TELEPHONE2_NAME_LOCATOR)).sendKeys("9234565453");

		driver.findElement(By.name(PASSWORD_NAME_LOCATOR)).sendKeys(sPassword);
		driver.findElement(By.name(CONFIRMATION_NAME_LOCATOR)).sendKeys(sPassword);

		if (!driver.findElement(By.id(NEWS_LETTER_LOCATOR)).isSelected()) {
			driver.findElement(By.id(NEWS_LETTER_LOCATOR)).click();
		}

		if (!driver.findElement(By.id(TERMS_LOCATOR)).isSelected()) {
			driver.findElement(By.id(TERMS_LOCATOR)).click();
		}

		// driver.findElement(By.id(NEWS_LETTER_LOCATOR)).sendKeys(Keys.SPACE);
		// driver.findElement(By.id(TERMS_LOCATOR)).sendKeys(Keys.SPACE);

		driver.findElement(By.name(ACTION_LOCATOR)).click();

		//Assert.assertEquals(driver.getTitle(), "Ez Shop Online");
		//Assert.assertEquals(driver.getCurrentUrl(), "http://ecommerce.saipratap.net/thankyoumessage.php?msg=reg");

		String ConfirmationMessage = driver.findElement(By.xpath(".//*[@class='fntstyle']")).getText();
		String MemberAlreadyExistMessage = driver.findElement(By.xpath(".//*[@class='msg']")).getText();
		
		if (ConfirmationMessage.equals(MESSAGE_LOCATOR)) {
			System.out.println("Customer Registration Successful – Passed");
		} else if (ConfirmationMessage.equals(ALREADY_EXIST_MESSAGE_LOCATOR)) {
			System.out.println("Customer Registration Unsuccessful - Email Already Exist – Failed");
		} else {
			System.out.println("Customer Registration Unsuccessful – Failed");
		}

	}

	@Test
	public void testwithLogin() {
		driver.get("http://ecommerce.saipratap.net/customerlogin.php");
		driver.findElement(By.id(EMAIL_NAME_LOCATOR)).sendKeys("Rahman");
		driver.findElement(By.id(PASSWORD_NAME_LOCATOR)).sendKeys("Mohommed");
		driver.findElement(By.name(ACTION_LOCATOR)).click();
	}

}
