package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Config;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	public void click(String xpath) {
// Create an instance of WebDriverWait with a timeout of, for example, 10 seconds.
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

		// Use the wait object to wait until the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		Config.driver.findElement(By.xpath(xpath)).click();

	}

	public void fill(String xpath, String input) {

		Config.driver.findElement(By.xpath(xpath)).sendKeys(input);

	}

	
	
	public void goToUrl(String url){
		
		Config.driver.get(url);
		
		
	}
	
	


		
		
		
	
	
}
