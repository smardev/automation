package helper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Config {

	public static WebDriver driver;

	public static void ConfDriver() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-mac-arm64/chromedriver");

	}

	public static void delai(long x) {

		Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(x));

	}

}
