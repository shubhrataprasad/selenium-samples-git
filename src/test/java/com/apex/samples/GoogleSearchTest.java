package com.apex.samples;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class GoogleSearchTest {
	public static void main(String[] args) throws InterruptedException {
		File file = new File("C:\\Working\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
				.withLogLevel(InternetExplorerDriverLogLevel.TRACE).withLogFile(new File("C:\\Working\\ie_shubh.log"))
				.build();

		WebDriver driver = new InternetExplorerDriver(service);
		driver.get("http://google.com");
		WebElement searboxElm = driver.findElement(By.name("q"));
		searboxElm.sendKeys("Java Book");
		searboxElm.submit();

		Thread.sleep(10);

		WebElement searchboxElm = driver.findElement(By.name("btnk"));
		searchboxElm.click();
		
		Thread.sleep(10);

		WebElement oGoogleSearchBtn = driver.findElement(By.xpath("//input[@name='btnG']"));  
        oGoogleSearchBtn.click();

		driver.close();

	}


}
