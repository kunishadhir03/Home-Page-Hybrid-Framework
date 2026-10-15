package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.HomePage;

public class MenuNavigationTest extends BaseTest {

    @Test
    public void verifyBooksNavigation() {

        HomePage home = new HomePage(driver);

        home.clickBooks();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("books"));
    }

    @Test
    public void verifyComputersNavigation() {

        HomePage home = new HomePage(driver);

        home.clickComputers();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("computers"));
    }

    @Test
    public void verifyElectronicsNavigation() {

        HomePage home = new HomePage(driver);

        home.clickElectronics();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("electronics"));
    }
}