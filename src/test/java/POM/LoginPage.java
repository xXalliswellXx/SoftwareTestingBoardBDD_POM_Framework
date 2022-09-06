package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePOM{

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInLink;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[text()='Sign In']/..")
    private WebElement signInButton;

    @FindBy(css = "span[class='logged-in']")
    private WebElement logInMessage;

    //String email = "blah@test.com";
    String email = "testblah@test.com";
    String password = "Test123.";

    public void navigateToLogInPage() {
        signInLink.click();

        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(signInButton.isDisplayed());
    }

    public void loginFunction() {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        waitUntilVisibleAndClickableThenClick(signInButton);
    }

    public void validateLoginMessage() {
        staleElementWait(logInMessage);
        Assert.assertTrue(logInMessage.isDisplayed());
    }

}
