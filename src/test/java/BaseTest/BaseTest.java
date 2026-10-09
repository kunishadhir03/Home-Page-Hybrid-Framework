package BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyReader;

public class BaseTest {
	
	public static WebDriver driver ;
	
	@BeforeMethod
	
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(PropertyReader.getProperty("url"));
	}
	
	@AfterMethod
	
	public void teardown() {
		
		if(driver != null) driver.quit();
	}

}
