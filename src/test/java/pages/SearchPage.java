package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("search"));
    }

    @FindBy(css=".product-item")
    List<WebElement> products;

    @FindBy(xpath="//div[contains(@class,'warning')]")
    List<WebElement> warningMessages;

    public int getResultCount() {

        return products.size();
    }

    public boolean isProductDisplayed() {

        return products.size() > 0;
    }

    public boolean isWarningDisplayed() {

        return warningMessages.size() > 0;
    }

    public String getPageTitle() {

        return driver.getTitle();
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }
}