package com.xcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.xcart.base.TestBase;

public class HomePage extends TestBase {
	
	
	public void searchProduct() {
		
		driver.findElement(By.xpath(prop.getProperty("searchBox"))).sendKeys(con.getProperty("itemName"));
		driver.findElement(By.xpath(prop.getProperty("searchBox"))).sendKeys(Keys.ENTER);
			
	}
	
	

}
