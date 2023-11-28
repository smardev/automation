Feature: automationintesting login page test suite
  
   As Admin i want to perform login tests

  Background: 
    Given User is on automationintesting "https://automationintesting.online/#/admin"

  Scenario Outline: Login to admin profile with valid credentials
    When User try to connect with valid Admin "<username>" and "<password>" and connect
    Then Admin is redirected to Home page that contains btn "Front Page"

    Examples: 
      | username | password |
      | admin    | password |

  Scenario Outline: Login to admin profile with invalid credentials
    When  User try to connect with invalid Admin "<username>" and "<password>" and connect
    Then  User is still in login Page 

    Examples: 
      | username | password   |
      | admin    | wrong      |
