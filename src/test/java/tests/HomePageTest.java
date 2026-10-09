
package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.HomePage;

@Listeners(listeners.ExtentTestNGListener.class)
public class HomePageTest extends BaseTest{
	
	@Test
	public void verifyHomePageTitle() {
		
		HomePage home = new HomePage(driver);
		
		Assert.assertEquals(home.getHomePageTitle() , "Demo Web Shop");
	}
	
	@Test
	
	public void verifySearchBox() {
		
		HomePage home = new HomePage(driver);
		
		Assert.assertTrue(home.isSearchBoxDisplayed());
	}
	
	@Test
	
	public void verifyBooksMenu() {
		
		HomePage home = new HomePage(driver);
		
		Assert.assertTrue(home.isBooksMenuDisplayed());
	}
	

}
