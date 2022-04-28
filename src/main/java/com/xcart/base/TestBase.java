package com.xcart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties con = new Properties();
	public static FileInputStream or;
	public static FileInputStream config;
	
	@BeforeSuite
	public void setUp() throws Exception {
		
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/com/xcart/driver/chromedriver");
			driver = new ChromeDriver();
			driver.get("https://mobile.x-cart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			or = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/com/xcart/properties/Object.properties");
			prop.load(or);
			
			config = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/com/xcart/properties/Config.properties");
			con.load(config);
		}
		
	}
	
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	

}
