package com.apex.samples.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ApexBaseTest {

	protected WebDriver driver = null;

	@BeforeMethod
	public void setup() {
		File file = new File("C:\\Working\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability("nativeEvents", false);
		
	
		InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
				.withLogLevel(InternetExplorerDriverLogLevel.TRACE).withLogFile(new File("C:\\Working\\ie_shubh.log"))
				.build();
	
		driver = new InternetExplorerDriver(service, capabilities);
		//driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1");
		driver.get("http://ecommerce.saipratap.net/customerlogin.php?cond=1");
	
	}

	@AfterMethod
	public void cleanup() {
		driver.close();
	}

}
