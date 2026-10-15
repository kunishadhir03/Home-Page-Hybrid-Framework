package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.HomePage;

public class NewsletterTest extends BaseTest {

    @Test
    public void verifyNewsletterSubscription() {

        HomePage home = new HomePage(driver);

        home.subscribeNewsletter(
                "test123@gmail.com");

        Assert.assertTrue(
                home.getNewsletterMessage().contains("successfully"));
    }
}