Feature: Address Test

  Background: Login Function
    Given User navigate to Login Page
    When User enter valid username and valid password
    Then User should see login success message

  Scenario Outline: Add new addresses
    When User add new address with "<StreetAddress>" "<City>" "<State>" "<ZipCode>" "<Country>" and "<PhoneNumber>"
    Then User should see new address success message

  Examples:
    | StreetAddress       | City        | State         | ZipCode       | Country       | PhoneNumber     |
    | Street One          | City One    | Arizona       | 25465         |United States  | 123456789       |
    | Street Two          | City Two    | Illinois      | 54568         |United States  | 123456789       |
    | Street Three        | City Three  | Mississippi   | 78515         |United States  | 123456789       |
