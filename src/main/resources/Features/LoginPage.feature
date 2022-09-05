Feature: Login Functionality

  Scenario: Login Test
    Given User navigate to Login Page
    When User enter valid "blah@test.com" and valid "Test123."
    Then User should see success message