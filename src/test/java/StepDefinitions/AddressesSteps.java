package StepDefinitions;

import POM.MyAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressesSteps {

    MyAccountPage myAccountPage;

    @When("User add new address with {string} {string} {string} {string} {string} and {string}")
    public void user_add_new_address_with_and(String streetAddress, String city, String state, String zipCode, String country, String phoneNumber) {
        myAccountPage = new MyAccountPage();

        myAccountPage.navigateToMyAccountPage();
        myAccountPage.createNewAddress(streetAddress, city, state, zipCode, country, phoneNumber);
    }

    @Then("User should see new address success message")
    public void user_should_see_new_address_success_message() {
        myAccountPage = new MyAccountPage();

        myAccountPage.validateSuccessMessage();
    }

}
