package stepDefinitions;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiAutomationTest {

    @Test
    public void testGetTodos() {
        // Initialize RestAssured base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Make GET request and validate the response
        given()
                .when()
                .get("/todos/")
                .then()
                .statusCode(200) // Verify status code is 200
                .body("id", hasItem(5)) // Verify that id 5 exists
                .body("find { it.id == 5 }.completed", equalTo(false)); // Verify completed is false for id 5

   System.out.println("the test is correct");
    }
}
