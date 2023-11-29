package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Config;

public class RoomPage extends BasePage {

	String frontBtnXpath = "//a[@id='frontPageLink']";

	String createRoomXpath = "//button[@id='createRoom']";
	
	
	String roomIDxpath = "//input[@id='roomName']";
	
	String typeXpath = "//select[@id='type']";
	
	String xpathPrice = "//input[@id='roomPrice']";

	public String getFrontPageText() {

		return Config.driver.findElement(By.xpath(frontBtnXpath)).getText();

	}

	public void createEmptyRoom() {

		click(createRoomXpath);

	}
	
	public void createRoom(String roomID, String roomTypeVisibleText, String price) {
		
		fill(frontBtnXpath, roomID);
		
		WebElement typeElement = Config.driver.findElement(By.xpath(typeXpath));
		
		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(typeElement);
		
		select.selectByVisibleText(roomTypeVisibleText);
		
		fill(xpathPrice, price);
		
		// pour eviter le cast j'utilise String pour le sendKeys
		
		click(createRoomXpath);
		
		
		
		
		
	}
	
	
	
	
}
