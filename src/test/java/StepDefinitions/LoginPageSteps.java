package StepDefinitions;

import POM.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    LoginPage loginPage;

    @Given("User navigate to Login Page")
    public void user_navigate_to_login_page() {
        loginPage = new LoginPage();
        loginPage.navigateToLogInPage();
    }

    @When("User enter valid {string} and valid {string}")
    public void user_enter_valid_and_valid(String email, String password) {
        loginPage = new LoginPage();

        loginPage.loginFunction(email, password);
    }

    @Then("User should see success message")
    public void user_should_see_success_message() {

    }

}
