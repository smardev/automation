package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		
		features = "src/test/resources/features/Login.feature",
		
		glue = "stepDefinitions",
		
		plugin = { "pretty", "html:target/orange-cucumber-report.html" }
		
		
		)

public class Runner {

}
