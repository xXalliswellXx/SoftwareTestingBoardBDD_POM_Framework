Feature: Place Order Test

  Scenario: Place random order
    Given User navigate to Login Page
    When User enter valid username and valid password
    Then User should see login success message
    When User place a new order
    Then User should see new order success message