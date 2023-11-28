package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sun.org.apache.bcel.internal.generic.Select;

import helper.Config;

public class BasePage {

	public void click(String xpath) {

		Config.driver.findElement(By.xpath(xpath)).click();

	}

	public void fill(String xpath, String input) {

		Config.driver.findElement(By.xpath(xpath)).sendKeys(input);

	}

	
	
	public void goToUrl(String url){
		
		Config.driver.get(url);
		
		
	}
	
	


		
		
		
	
	
}
