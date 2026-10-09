package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver ;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver ;
		
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox ;
	
	
	@FindBy(xpath = "//input[@value = 'Search']")
	WebElement searchButton ;
	
	@FindBy(xpath = "//div[@class = 'topic-html-content-header']")
	WebElement welcomeText;
	
	@FindBy(xpath = "//input[@id = 'newsletter-email']")
	WebElement newsletterEmail ;
	
	@FindBy(id = "newsletter-subscribe-button")
	WebElement subscribeButton ;
	
	@FindBy(linkText = "Books")
	WebElement booksMenu ;
	
	public String getHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean isSearchBoxDisplayed() {
		
		return searchTextBox.isDisplayed();
	}
	
	public void searchProduct(String product) {
		
		searchTextBox.clear();
		
		searchTextBox.sendKeys(product);
		
		searchButton.click();
	}
	
	public boolean isBooksMenuDisplayed() {
		
		return booksMenu.isDisplayed();
	}
	
	public void subscribeNewsletter(String email) {
		
		newsletterEmail.sendKeys(email);
		
		subscribeButton.click();
	}
	
}
