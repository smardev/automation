package helper;

		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;

		import java.time.Duration;

public class Config {

	public static WebDriver driver;

	static {
		// Set the system property for the WebDriver depending on your OS
		// For example, if you're on Windows:
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		// Or, if you're on Mac:
		// System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-mac");

		// Initialize the driver object
		driver = new ChromeDriver();

		// Set a default implicit wait (if desired)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Other methods or fields if needed
}
