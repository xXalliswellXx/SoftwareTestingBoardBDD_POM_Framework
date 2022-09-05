Feature: Login Functionality

  Scenario: Login Test
    Given User navigate to Login Page
    When User enter valid username and valid password
    Then User should see login success message