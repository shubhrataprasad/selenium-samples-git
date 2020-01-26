package com.apex.samples.core;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApexBaseChromeTest {

	protected WebDriver driver = null;
	private static ChromeDriverService service;
	private static File file;

	@BeforeClass
	public static void createAndStartService() throws IOException {
		file = new File("C:\\Working\\chromedriver_win32\\chromedriver.exe");
		service = new ChromeDriverService.Builder().usingDriverExecutable(file).usingAnyFreePort().build();
		service.start();
	}

	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	@BeforeMethod
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Working\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1");
		//driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1http://ecommerce.saipratap.net/customerlogin.php?cond=1");
		//driver.manage().window().maximize();
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

	/*@Test
	public void testGoogleSearch() {
		driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1");
	}
*/
}
