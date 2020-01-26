package com.apex.samples;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailTestPage {
	private static final String GMAIL_NAME_LOCATOR = "Gmail";

	public static void GmailTestPageTest() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		boolean existence = driver.findElement(By.linkText(GMAIL_NAME_LOCATOR)).isDisplayed();

		if (existence == true) {
			System.out.println("Gmail Link Exists – Passed");
		} else {
			System.out.println("Gmail Link Not Exists – Failed");
		}

		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.google.com/");
		try {
			if (driver.findElement(By.linkText("Gmailabc")).isDisplayed()) {
				System.out.println("Gmail Link Exists – Passed");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Gmail Link Not Exists – Failed");
		}
		driver.close();
	}
}