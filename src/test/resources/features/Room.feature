Feature:
  Room Creation Validation
  
   As Admin i want to perform room tests on Room Page

  Background: 
    Given User is on automationintesting "https://automationintesting.online/#/admin"
    And Admin is connected with "admin" and "password"

  Scenario: Empty Room Creation
    When Admin try to create an emty room
    Then A message "Room name must be set" appear

  Scenario Outline: Room Creation
    When Admin creates a room with "<roomId>" and "<type>" and "<accessible>" and "<price>" and "<roomDetails>"
    Then room is created

    Examples: 
      | roomId | type  | accessible | price | roomDetails |
      |     25 | Twin  | true       |   500 | Wifi        |
      |     26 | Suite | true       |   450 | Wifi        |










Feature: Room Creation Validation

  Background: Admin is logged into the B&B Booking Management platform
    Given Admin is on the Admin login page
    When Admin enters username "admin" and password "password"
    And Admin clicks the login button
    Then Admin should be redirected to the Dashboard

  Scenario: Validate creation and listing of the first room
    When Admin navigates to the room creation section
    And Admin enters details for the first new room
    And Admin submits the room creation form
    Then Admin should see a confirmation message for the first room creation
    And The first new room should appear in the room list with correct details

  Scenario: Validate creation and listing of the second room
    When Admin navigates to the room creation section
    And Admin enters details for the second new room
    And Admin submits the room creation form
    Then Admin should see a confirmation message for the second room creation
    And The second new room should appear in the room list with correct details

