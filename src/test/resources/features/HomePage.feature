Feature: 
  automationintesting Home page test suite
  
   As Admin i want to perform room tests on Home Page

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
