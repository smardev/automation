package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import pages.LoginPage;

public class CommonStepDefinitions {
	
    pages.LoginPage page;

	@Before
	public void init() {

		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        helper.Config.driver = new ChromeDriver();

	}

	@Given("User is on automationintesting {string}")
	public void user_is_on_autoamtion_page(String url) {
		
		page = new LoginPage();

       page.goToUrl(url);
       helper.Config.driver.manage().window().maximize();

	}
	
	
	@Given("Admin is connected with {string} and {string}")
		public void admin_is_connected(String usrname, String password) throws InterruptedException {
		
		page = new LoginPage();
		
		page.connect(usrname, password);
		
		
		
	}
	
	
	


	
	

}
