package com.xcart.testcases;
import org.testng.annotations.Test;
import com.xcart.pages.HomePage;

public class HomePageTest {

	@Test
	public void testHomePage() throws Exception {
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage();
		obj.searchProduct();
	}

}
