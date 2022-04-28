package com.xcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.xcart.base.TestBase;

public class HomePage extends TestBase {
	
	
	public void searchProduct() {
		
		driver.findElement(By.xpath("(//input[@placeholder='Search items...'])[1]")).sendKeys("Product");
		driver.findElement(By.xpath("(//input[@placeholder='Search items...'])[1]")).sendKeys(Keys.ENTER);
			
	}
	
	

}
