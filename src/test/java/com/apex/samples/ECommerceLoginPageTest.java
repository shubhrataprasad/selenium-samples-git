package com.apex.samples;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class ECommerceLoginPageTest {
	public static void main(String[] args) throws InterruptedException {
		File file = new File("C:\\Working\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
				.withLogLevel(InternetExplorerDriverLogLevel.TRACE).withLogFile(new File("C:\\Working\\ie_shubh.log"))
				.build();

		WebDriver driver = new InternetExplorerDriver(service);
		driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1");
		driver.findElement(By.name("email")).sendKeys("test2@gmail.com");
		driver.findElement(By.name("password")).sendKeys("pwd2");
		driver.findElement(By.linkText("Login")).click();
		
		String title = driver.getTitle();
		if(title.equals("Ez Shop Online")) {
			System.out.println("Test is passed");
		} else {
			System.out.println("Test is failed");
		}

		driver.close();

	}


}



