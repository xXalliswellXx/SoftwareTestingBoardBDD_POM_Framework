package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyAccountPage extends BasePOM {

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li[class='customer-welcome']>span>button")
    private WebElement accountActionsButton;

    @FindBy(xpath = "//a[text()='My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//span[text()='Manage Addresses']/..")
    private WebElement manageAddressesLink;

    @FindBy(xpath = "//strong[text()='Default Addresses']")
    private WebElement defaultAddressesText;

    @FindBy(css = "button[role='add-address']")
    private WebElement addAddressButton;

    @FindBy(id = "street_1")
    private WebElement streetAddressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "region_id")
    private WebElement stateDropdown;

    @FindBy(id = "zip")
    private WebElement zipCodeInput;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "telephone")
    private WebElement phoneNumberInput;

    @FindBy(css = "button[title='Save Address']")
    private WebElement saveAddressButton;

    @FindBy(xpath = "//div[text()='You saved the address.']")
    private WebElement newAddressSuccessMessage;

    public void navigateToMyAccountPage() {
        waitUntilVisibleAndClickableThenClick(accountActionsButton);
        waitUntilVisibleAndClickableThenClick(myAccountButton);
    }

    public void createNewAddress(String streetAddress, String city, String state, String zipCode, String country, String phoneNumber) {

        waitUntilVisibleAndClickableThenClick(manageAddressesLink);

        if (defaultAddressesText.isDisplayed())
            waitUntilVisibleAndClickableThenClick(addAddressButton);

        wait.until(ExpectedConditions.visibilityOf(streetAddressInput));
        streetAddressInput.sendKeys(streetAddress);
        cityInput.sendKeys(city);

        Select select = new Select(stateDropdown);
        select.selectByVisibleText(state);

        zipCodeInput.sendKeys(zipCode);

        select = new Select(countryDropdown);
        select.selectByVisibleText(country);

        phoneNumberInput.sendKeys(phoneNumber);

        waitUntilVisibleAndClickableThenClick(saveAddressButton);
    }

    public void validateSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(newAddressSuccessMessage));
        Assert.assertTrue(newAddressSuccessMessage.isDisplayed());
    }

}
