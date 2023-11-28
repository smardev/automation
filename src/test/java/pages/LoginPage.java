package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

	
	String xpathUsername = "//input[@id='username']";
	String xpathPassword = "//input[@id='password']";
	String xpathConnect = "//button[@id='doLogin']";





	public void connect(String usernam, String passwod) throws InterruptedException {

     
		fill(xpathUsername, usernam);
		
		fill(xpathPassword, passwod);

		
		click(xpathConnect);

	}



}
