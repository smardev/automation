//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import helper.Config;
//
//import static helper.Config.driver;
//
//public class RoomPage extends BasePage {
//
//	String frontBtnXpath = "//a[@id='frontPageLink']";
//
//	String createRoomXpath = "//button[@id='createRoom']";
//
//
//	String roomIDxpath = "//input[@id='roomName']";
//
//	String typeXpath = "//select[@id='type']";
//
//	String xpathPrice = "//input[@id='roomPrice']";
//
//	public String getFrontPageText() {
//
//		return driver.findElement(By.xpath(frontBtnXpath)).getText();
//
//	}
//
//	public void createEmptyRoom() {
//
//		click(createRoomXpath);
//
//	}
//
//	public void createRoom(String roomID, String roomTypeVisibleText, String price) {
//
//		fill(frontBtnXpath, roomID);
//
//		WebElement typeElement = driver.findElement(By.xpath(typeXpath));
//
//		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(typeElement);
//
//		select.selectByVisibleText(roomTypeVisibleText);
//
//		fill(xpathPrice, price);
//
//		// pour eviter le cast j'utilise String pour le sendKeys
//
//		click(createRoomXpath);
//
//
//
//
//
//	}
//
//
	
	
//}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static helper.Config.driver;

public class RoomPage extends BasePage {

	// XPaths for the web elements
		String frontBtnXpath = "//a[@id='frontPageLink']";

	private String roomNumberInputXpath = "//input[@id='roomNumber']";
	private String roomTypeDropdownXpath = "//select[@id='roomType']";
	private String accessibleDropdownXpath = "//select[@id='accessible']";
	private String priceInputXpath = "//input[@id='price']";
	private String createButtonXpath = "//button[@id='createRoom']";
	// XPath template for amenities checkbox, %s will be replaced by the amenity name
	private String amenityCheckboxXpathTemplate = "//input[@type='checkbox' and following-sibling::label[normalize-space(text())='%s']]";

	public RoomPage(WebDriver driver) {
		super(driver);
	}
	public String getFrontPageText() {

		return driver.findElement(By.xpath(frontBtnXpath)).getText();

	}
	public void enterRoomNumber(String number) {
		WebElement roomNumberInput = driver.findElement(By.xpath(roomNumberInputXpath));
		roomNumberInput.clear();
		roomNumberInput.sendKeys(number);
	}

	public void selectRoomType(String type) {
		WebElement roomTypeDropdown = driver.findElement(By.xpath(roomTypeDropdownXpath));
		new Select(roomTypeDropdown).selectByVisibleText(type);
	}

	public void setRoomAccessibility(boolean accessible) {
		WebElement accessibleDropdown = driver.findElement(By.xpath(accessibleDropdownXpath));
		new Select(accessibleDropdown).selectByValue(String.valueOf(accessible));
	}

	public void enterRoomPrice(String price) {
		WebElement priceInput = driver.findElement(By.xpath(priceInputXpath));
		priceInput.clear();
		priceInput.sendKeys(price);
	}

	public void toggleAmenity(String amenity, boolean shouldBeSelected) {
		String amenityCheckboxXpath = String.format(amenityCheckboxXpathTemplate, amenity);
		WebElement amenityCheckbox = driver.findElement(By.xpath(amenityCheckboxXpath));
		if (shouldBeSelected != amenityCheckbox.isSelected()) {
			amenityCheckbox.click();
		}
	}

	public void submitRoomForm() {
		WebElement createButton = driver.findElement(By.xpath(createButtonXpath));
		createButton.click();
	}
}
