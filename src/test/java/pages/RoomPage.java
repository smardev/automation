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

import helper.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static helper.Config.driver;

public class RoomPage extends BasePage {

	// XPaths for the web elements
		String frontBtnXpath = "//a[@id='frontPageLink']";


	private static String roomNumberInputXpath = "//input[@id='roomName']";
	private static String roomTypeDropdownXpath = "//select[@id='type']";
	private static String accessibleDropdownXpath = "//select[@id='accessible']";
	private static String priceInputXpath = "//input[@id='roomPrice']";
	private  String createButtonXpath = "//button[@id='createRoom']";
	// XPath template for amenities checkbox, %s will be replaced by the amenity name
	private static final String amenityCheckboxXpathTemplate = "//input[@type='checkbox' and following-sibling::label[normalize-space(text())='%s']]";

	public RoomPage(WebDriver driver) {
		super(driver);
	}
	public String getFrontPageText() {

		return driver.findElement(By.xpath(frontBtnXpath)).getText();

	}
	public void enterRoomNumber(String number) {
		// Create an instance of WebDriverWait with a timeout of, for example, 10 seconds.
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

		// Use the wait object to wait until the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(roomNumberInputXpath)));
		WebElement roomNumberInput = driver.findElement(By.xpath(roomNumberInputXpath));
		roomNumberInput.clear();
		roomNumberInput.sendKeys(number);
	}
		public void createEmptyRoom() {

		click(createButtonXpath);

	}
	public void selectRoomType(String type) {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

		// Use the wait object to wait until the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(roomTypeDropdownXpath)));
		WebElement roomTypeDropdown = driver.findElement(By.xpath(roomTypeDropdownXpath));
		new Select(roomTypeDropdown).selectByVisibleText(type);
	}

	public void setRoomAccessibility(boolean accessible) {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

		// Use the wait object to wait until the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accessibleDropdownXpath)));
		WebElement accessibleDropdown = driver.findElement(By.xpath(accessibleDropdownXpath));
		new Select(accessibleDropdown).selectByValue(String.valueOf(accessible));
	}

	public void enterRoomPrice(String price) {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

		// Use the wait object to wait until the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(priceInputXpath)));
		WebElement priceInput = driver.findElement(By.xpath(priceInputXpath));
		priceInput.clear();
		priceInput.sendKeys(price);
	}

//	public void toggleAmenity(String amenity, boolean shouldBeSelected) {
//		String amenityCheckboxXpath = String.format(amenityCheckboxXpathTemplate, amenity);
//		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
//
//		// Use the wait object to wait until the element is clickable
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(amenityCheckboxXpath)));
//		WebElement amenityCheckbox = driver.findElement(By.xpath(amenityCheckboxXpath));
//		if (shouldBeSelected != amenityCheckbox.isSelected()) {
//			amenityCheckbox.click();
//		}
//	}

	public void selectAmenities(List<String> amenities) {
		for (String amenity : amenities) {

			// Use the wait object to wait until the element is clickable
			String checkboxXpath = String.format(amenityCheckboxXpathTemplate, amenity);

			WebElement checkbox = driver.findElement(By.xpath(checkboxXpath));
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	public void submitRoomForm() {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

		// Use the wait object to wait until the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createButtonXpath)));
		WebElement createButton = driver.findElement(By.xpath(createButtonXpath));
		createButton.click();
	}
}
