package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePOM {

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#ui-id-4")
    private WebElement womenSectionLink;

    @FindBy(id = "ui-id-9")
    private WebElement womenTopslink;

    @FindBy(id = "ui-id-11")
    private WebElement womenJacketsLink;

    @FindAll(@FindBy(css = "ol[class='products list items product-items']>li"))
    private List<WebElement> productList;

    @FindBy(css = "a.action.showcart")
    private WebElement showCartLink;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "input[name='ko_unique_1']")
    private WebElement shippingMethodRadioButton;

    @FindBy(css = "button[data-role='opc-continue']")
    private WebElement nextButton;

    @FindBy(css = "button.action.primary.checkout")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    private WebElement orderSuccessMessage;

    public void purchaseFunction() {

        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(womenSectionLink));
        actions.moveToElement(womenSectionLink).perform();
        actions.moveToElement(womenTopslink).perform();
        waitUntilVisibleAndClickableThenClick(womenJacketsLink);


        int randomElement = new Random().nextInt(productList.size());
        actions.moveToElement(productList.get(randomElement)).perform();

        List<WebElement> sizes = productList.get(randomElement).findElements(By.cssSelector("div.swatch-attribute.size>div>div"));
        sizes.get(new Random().nextInt(sizes.size())).click();

        List<WebElement> colors = productList.get(randomElement).findElements(By.cssSelector("div.swatch-attribute.color>div>div"));
        colors.get(new Random().nextInt(colors.size())).click();

        WebElement addToCartButton = productList.get(randomElement).findElement(By.cssSelector("div.actions-primary>form>button"));
        waitUntilVisibleAndClickableThenClick(addToCartButton);

        waitUntilVisibleAndClickableThenClick(showCartLink);
        waitUntilVisibleAndClickableThenClick(proceedToCheckoutButton);

        waitUntilVisibleAndClickableThenClick(shippingMethodRadioButton);
        waitUntilVisibleAndClickableThenClick(nextButton);

        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", placeOrderButton);

    }

    public void validateOrderSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(orderSuccessMessage));
        Assert.assertTrue(orderSuccessMessage.isDisplayed());
    }

}
