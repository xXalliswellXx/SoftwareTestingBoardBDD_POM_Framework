package StepDefinitions;

import POM.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseSteps {

    HomePage homePage;

    @When("User place a new order")
    public void user_place_a_new_order() {
        homePage = new HomePage();

        homePage.purchaseFunction();
    }

    @Then("User should see new order success message")
    public void user_should_see_new_order_success_message() {
        homePage = new HomePage();

        homePage.validateOrderSuccessMessage();
    }

}
