package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefinition {
	
	
	
	@When("^Admin creates a room with {string} and {string} and {string} and {string} and {string}")
	public void admin_try_to_connect_with_valid_username_and_password_and_connect(String roomId, String type)
			throws InterruptedException {

//		login = new pages.LoginPage(helper.Config.driver);
		



	}

	@Then("Admin is redirected to Home page that contains btn {string}")
	public void admin_is_redirected_to_home_page_that_contains_message(String msg) throws InterruptedException {



	}

	
	

}
