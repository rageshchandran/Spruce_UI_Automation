package com.xcart.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.xcart.base.TestBase;
import com.xcart.model.Product;
import com.xcart.utility.GenericFunctions;
import com.xcart.utility.TextWriter;

public class ProductPage extends TestBase {

	TextWriter txt = new TextWriter();
	GenericFunctions fn = new GenericFunctions();

	public void getProductResult() throws Exception {
		
		//getting the total number of product in the result page
		String strResult = driver.findElement(By.xpath("//*[@class='head-h2 ']")).getText();
		String countOfProduct = strResult.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(countOfProduct);
		clickProduct();

		for (int i = 0; i < count; i++) {

			Product item = readProductInfo();
			writeProductInfo(item);
			goToNextPage();

		}
	}

	private void writeProductInfo(Product obj) throws Exception {

		txt.writeToFile("ProductTitle: "+obj.getProductTitle());
		txt.writeToFile("Product Price: "+obj.getProductPrice());
		txt.writeToFile("Product description: "+obj.getProductDescription());
		txt.writeToFile("Product url: " +obj.getProductUrl());
		txt.writeToFile("\n************************************************************************************************************************************************\n");

	}

	private Product readProductInfo() {
		Product product = new Product();
		product.setProductTitle(driver.findElement(By.cssSelector(".fn.title")).getText());
		product.setProductPrice(driver.findElement(By.cssSelector("div[class='product-details-info'] span[class='price product-price']")).getText());
		List<String> arrPara = new ArrayList<String>();
		List<WebElement> allDescription = driver.findElements(By.xpath("//*[@class='description product-description']//child::p"));
		// loop through all paragraph elements
		for (WebElement ele : allDescription) {
			arrPara.add(ele.getText());

		}
		product.setProductDescription(arrPara.toString());
		product.setProductUrl(driver.getCurrentUrl());
		return product;
	}

	public void clickProduct() {

		driver.findElement(By.xpath("(//*[@class='fn url next-previous-assigned'])[1]")).click();
		WebElement addCart = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Add to cart')]"));
		fn.isElementDisplayed(addCart);

	}

	// to navigate to NextPage
	public void goToNextPage() {

		List<WebElement> list = driver.findElements(By.xpath("//a[normalize-space()='Next product']"));
		//System.out.println(list.size());
		if (list.size() > 0) {
			driver.findElement(By.xpath("//a[normalize-space()='Next product']")).click();
		}

	}

}
