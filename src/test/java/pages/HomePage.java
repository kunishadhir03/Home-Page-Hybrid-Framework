package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // Search Store

    @FindBy(id = "small-searchterms")
    WebElement searchTextbox;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    // Menu Navigation

    @FindBy(linkText = "Books")
    WebElement booksMenu;

    @FindBy(linkText = "Computers")
    WebElement computersMenu;

    @FindBy(linkText = "Electronics")
    WebElement electronicsMenu;

    // Newsletter

    @FindBy(id = "newsletter-email")
    WebElement newsletterEmail;

    @FindBy(id = "newsletter-subscribe-button")
    WebElement subscribeButton;

    @FindBy(id = "newsletter-result-block")
    WebElement newsletterMessage;

    // Popular Tags

    @FindBy(linkText = "computer")
    WebElement popularComputerTag;

    // Footer

    @FindBy(linkText = "Sitemap")
    WebElement sitemapLink;

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    public String getHomePageTitle() {

        return driver.getTitle();
    }

    public boolean isSearchBoxDisplayed() {

        return searchTextbox.isDisplayed();
    }

    public void searchProduct(String product) {

        searchTextbox.clear();

        searchTextbox.sendKeys(product);

        searchButton.click();
    }

    public boolean isBooksMenuDisplayed() {

        return booksMenu.isDisplayed();
    }

    public void clickBooks() {

        booksMenu.click();
    }

    public void clickComputers() {

        computersMenu.click();
    }

    public void clickElectronics() {

        electronicsMenu.click();
    }

    public void subscribeNewsletter(String email) {

        newsletterEmail.clear();

        newsletterEmail.sendKeys(email);

        subscribeButton.click();
    }

    public String getNewsletterMessage() {

        return newsletterMessage.getText();
    }

    public void clickPopularComputerTag() {

        popularComputerTag.click();
    }

    public void clickSitemap() {

        sitemapLink.click();
    }

    public void clickContactUs() {

        contactUsLink.click();
    }

    public void clickMyAccount() {

        myAccountLink.click();
    }
}