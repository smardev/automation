package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

    pages.LoginPage login;

   pages.HomePage d;

	@When("^User try to connect with valid Admin \"([^\"]*)\" and \"([^\"]*)\" and connect")
	public void admin_try_to_connect_with_valid_username_and_password_and_connect(String username, String password)
			throws InterruptedException {

//		login = new pages.LoginPage(helper.Config.driver);
		
		login = new pages.LoginPage();

		login.connect(username, password);


	}

	@Then("Admin is redirected to Home page that contains btn {string}")
	public void admin_is_redirected_to_home_page_that_contains_message(String msg) throws InterruptedException {

		d = new pages.HomePage();
		
		// J'ai ajouté Thread.sleep car le wait implicite n'a pas fonctionné 
		Thread.sleep(5000);
		
		String actualResult = d.getFrontPageText();
		
		Assert.assertEquals(msg, actualResult);


	}



}
