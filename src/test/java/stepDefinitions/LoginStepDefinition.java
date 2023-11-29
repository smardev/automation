package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RoomPage;

import static helper.Config.driver;

public class LoginStepDefinition {

    pages.LoginPage login;

   RoomPage d;

	@When("^User try to connect with valid Admin \"([^\"]*)\" and \"([^\"]*)\" and connect")
	public void admin_try_to_connect_with_valid_username_and_password_and_connect(String username, String password)
			throws InterruptedException {

//		login = new pages.LoginPage(helper.Config.driver);
		
		login = new pages.LoginPage(driver);

		login.connect(username, password);


	}

	@Then("Admin is redirected to Home page that contains btn {string}")
	public void admin_is_redirected_to_home_page_that_contains_message(String msg) throws InterruptedException {

		d = new RoomPage(driver);
		
		// J'ai ajouté Thread.sleep car le wait implicite n'a pas fonctionné 
		Thread.sleep(5000);
		
		String actualResult = d.getFrontPageText();
		
		Assert.assertEquals(msg, actualResult);


	}


	@When("User try to connect with invalid Admin {string} and {string} and connect")
	public void userTryToConnectWithInvalidAdminAndAndConnect(String username, String password) throws InterruptedException {
		//		login = new pages.LoginPage(helper.Config.driver);
		login = new pages.LoginPage(driver);

		login.connect(username, password);

	}

	@Then("User is still in login Page")
	public void userIsStillInLoginPage() {
	}
}
