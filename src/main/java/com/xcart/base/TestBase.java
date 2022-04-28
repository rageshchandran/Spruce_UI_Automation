package com.xcart.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "/Users/Ragesh/eclipse-workspace/SpruceAssessment/src/test/resources/com/xcart/driver/chromedriver");
			driver = new ChromeDriver();
			driver.get("https://mobile.x-cart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
	}
	
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	

}
