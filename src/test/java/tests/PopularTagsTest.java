package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.HomePage;

public class PopularTagsTest extends BaseTest {

    @Test
    public void verifyPopularComputerTag() {

        HomePage home = new HomePage(driver);

        home.clickPopularComputerTag();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("computer"));
    }
}