package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.HomePage;

public class FooterLinksTest extends BaseTest {

    @Test
    public void verifySitemapLink() {

        HomePage home = new HomePage(driver);

        home.clickSitemap();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("sitemap"));
    }

    @Test
    public void verifyContactUsLink() {

        HomePage home = new HomePage(driver);

        home.clickContactUs();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("contactus"));
    }

    @Test
    public void verifyMyAccountLink() {

        HomePage home = new HomePage(driver);

        home.clickMyAccount();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("customer"));
    }
}