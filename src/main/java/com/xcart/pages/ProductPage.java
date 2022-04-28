package com.xcart.pages;

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
		String strResult = driver.findElement(By.xpath(prop.getProperty("productResultHeader"))).getText();
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
		if(obj.getProductTitle().equalsIgnoreCase("Gunnar Vayper Gaming Glasses")) {
			List<String> arr = new ArrayList<String>();
			List<WebElement> getGlassesdecs = driver.findElements(By.xpath(prop.getProperty("getGlassesdecs")));
			for (WebElement ele : getGlassesdecs) {
				arr.add(ele.getText());

			}
			String gdescription = arr.toString();
			txt.writeToFile("Product description: "+gdescription);
		}else {
			txt.writeToFile("Product description: "+obj.getProductDescription());
		}
		
		txt.writeToFile("Product url: " +obj.getProductUrl());
		txt.writeToFile("\n************************************************************************************************************************************************\n");

	}

	private Product readProductInfo() {
		Product product = new Product();
		product.setProductTitle(driver.findElement(By.cssSelector(prop.getProperty("productTitle"))).getText());
		product.setProductPrice(driver.findElement(By.cssSelector(prop.getProperty("productPrice"))).getText());
		List<String> arrPara = new ArrayList<String>();
		List<WebElement> allDescription = driver.findElements(By.xpath(prop.getProperty("productDesc")));
		// loop through all paragraph elements
		for (WebElement ele : allDescription) {
			arrPara.add(ele.getText());

		}
		product.setProductDescription(arrPara.toString());
		product.setProductUrl(driver.getCurrentUrl());
		return product;
		
	}

	public void clickProduct() {

		driver.findElement(By.xpath(prop.getProperty("firstProduct"))).click();
		WebElement addCart = driver.findElement(By.xpath(prop.getProperty("addToCartButton")));
		fn.isElementDisplayed(addCart);

	}

	// to navigate to NextPage
	public void goToNextPage() {

		List<WebElement> list = driver.findElements(By.xpath(prop.getProperty("nextPageLink")));
		//System.out.println(list.size());
		if (list.size() > 0) {
			driver.findElement(By.xpath(prop.getProperty("nextPageLink"))).click();
		}

	}

}
