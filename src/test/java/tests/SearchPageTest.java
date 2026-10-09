package tests;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.HomePage;
import pages.SearchPage;
import utilities.ExcelUtility;
import utilities.ScreenshotUtility;

public class SearchPageTest extends BaseTest{
	
	@DataProvider(name = "SearchData")
	
	public Object[][] data() throws IOException{
		
		return ExcelUtility.getData();
	}
	
	@Test(dataProvider = "SearchData")
	
	public void productSearchTest(String product) {
		
		HomePage home = new HomePage(driver);
		
		home.searchProduct(product);
		
		SearchPage search = new SearchPage(driver);
		
		
	
		//Assert.assertTrue(search.getPageTitle().contains("Search"));
		
		//Assert.assertTrue(
		       // driver.getCurrentUrl().contains("search"),
		        //"Search page not opened for : " + product);
		
		System.out.println("Product : " + product);
		System.out.println("Title : " + search.getPageTitle());
		System.out.println("URL : " + search.getCurrentUrl());
		
		 ScreenshotUtility.captureScreenshot(
		            driver,
		            "Search_" + product);
		
		 Assert.assertFalse(
		search.getPageTitle().isEmpty(),
		"Search operation failed for : " + product);
		
	}
	
	

}
