package com.xcart.testcases;

import org.testng.annotations.Test;

import com.xcart.pages.ProductPage;

public class ProductPageTest {
	
	@Test
	public void testProductPage() throws Exception {
		
		ProductPage obj1 = new ProductPage();
		obj1.getProductResult();
	}
	
	

}
