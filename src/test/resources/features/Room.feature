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
      |     101 | Twin  | true       |   500 | Wifi,Safe      |
      |     102 | Suite | true       |   450 | TV, Radio, Refreshments      |


  Scenario Outline: Creating a room with various details
    Given The admin is on the room creation page
    When The admin selects room type "<Type>"
    And The admin sets accessibility to "<Accessible>"
    And The admin creates a room with the rest of details "<RoomNumber>", "<Price>", and "<RoomDetails>"
    Then The room should be created successfully

    Examples:
      | RoomNumber | Type   | Accessible | Price | RoomDetails        |
      | 301        | Single | false      | 120   | WiFi, Safe         |
      | 302        | Double | true       | 150   | TV, Radio, Refreshments |











