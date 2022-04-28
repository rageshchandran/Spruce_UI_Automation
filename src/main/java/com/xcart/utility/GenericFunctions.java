package com.xcart.utility;

import org.openqa.selenium.WebElement;

public class GenericFunctions {
	
	public void isElementDisplayed(WebElement ele) {
		
		if(ele.isDisplayed()) {
			System.out.println("Product page displayed successfully");
		}
		
	}

}
