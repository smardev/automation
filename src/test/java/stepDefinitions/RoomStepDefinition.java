//package stepDefinitions;
//
//import io.cucumber.java.en.When;
//
//public class RoomStepDefinition {
//
//
//
////	@When("Admin creates a room with {string} and {string} and {string} and {string} and {string}")
////	public void admin_try_to_connect_with_valid_username_and_password_and_connect(String roomId, String type)
////			throws InterruptedException {
////
//////		login = new pages.LoginPage(helper.Config.driver);
////
////
////
////
////	}
//
//	@When("Admin creates a room with {string} and {string} and {string} and {string} and {string}")
//	public void admin_creates_a_room_with_details(String roomId, String type, String accessible, String price, String roomDetails)
//			throws InterruptedException {
//		// Implementation for creating a room
//	}
//
//
////	@Then("Admin is redirected to Home page that contains btn {string}")
////	public void admin_is_redirected_to_home_page_that_contains_message(String msg) throws InterruptedException {
////
////
////
////	}
//
//
//
//
//}
package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.RoomPage;
import helper.Config;

import static helper.Config.driver;

public class RoomStepDefinition {

	private RoomPage roomPage;

	public RoomStepDefinition() {
		roomPage = new RoomPage(Config.driver);
	}



	@When("Admin try to create an emty room")
	public void admin_try_to_create_an_empty_room() {
		 roomPage = new pages.RoomPage(driver);

		roomPage.createEmptyRoom();	}

	@Then("A message {string} appear")
	public void a_message_appear(String message) {
		// implementation code
		// you might want to find the element that contains the message and assert its text
	}

// And similar for the other steps

	@When("Admin creates a room with {string}, {string}, {string}, {string}, and {string}")
	public void admin_creates_a_room_with_details(String roomId, String type, String accessible, String price, String roomDetails) throws InterruptedException {
		// Convert accessible and roomDetails to the expected types if necessary
		boolean isAccessible = accessible.equalsIgnoreCase("true");
		// Assuming roomDetails is a comma-separated list of amenities
		String[] amenities = roomDetails.split(",\\s*");

		// Navigate to the room creation page if not already there
		// ...

		// Now, interact with the RoomPage to create a room
		roomPage.enterRoomNumber(roomId);
		roomPage.selectRoomType(type);
		roomPage.setRoomAccessibility(isAccessible);
		roomPage.enterRoomPrice(price);

		for (String amenity : amenities) {
			roomPage.toggleAmenity(amenity, true); // You'll need to implement this method in RoomPage
		}

		roomPage.submitRoomForm(); // You'll need to implement this method in RoomPage
	}
}
