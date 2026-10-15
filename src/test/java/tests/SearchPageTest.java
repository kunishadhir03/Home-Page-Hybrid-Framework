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

public class SearchPageTest extends BaseTest {

    @DataProvider(name = "SearchData")
    public Object[][] data() throws IOException {

        return ExcelUtility.getData();
    }

    @Test(dataProvider = "SearchData")
    public void productSearchTest(String product) {

        HomePage home = new HomePage(driver);

        home.searchProduct(product);

        SearchPage search = new SearchPage(driver);

        System.out.println(
                "Searching Product : "
                        + product);

        System.out.println(
                "Current URL : "
                        + search.getCurrentUrl());

        System.out.println(
                "Page Title : "
                        + search.getPageTitle());

        ScreenshotUtility.captureScreenshot(
                driver,
                "Search_" + product);

        if(search.isProductDisplayed()) {

            System.out.println(
                    "Valid Product Found");

            Assert.assertTrue(
                    search.getResultCount() > 0,
                    "Search Results Not Displayed");

        } else {

            System.out.println(
                    "No Product Found");

            Assert.assertTrue(
                    search.isWarningDisplayed(),
                    "Warning Message Not Displayed");
        }
    }
}