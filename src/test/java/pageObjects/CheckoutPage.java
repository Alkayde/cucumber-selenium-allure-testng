package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p.product-name")
    private WebElement productName;
    @FindBy(css = "p.quantity")
    private WebElement quantity;
    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;
    @FindBy(css = "button.promoBtn")
    private WebElement applyButton;

    public String getProductName() {
        return productName.getText();
    }

    public String getQuantity() {
        wait.until(ExpectedConditions.visibilityOf(quantity));
        return quantity.getText();
    }

    public boolean placeOrderButtonIsDisplayedAndActive() {
        return placeOrderButton.isDisplayed() && placeOrderButton.isEnabled();
    }

    public boolean applyButtonIsDisplayedAndActive() {
        return applyButton.isDisplayed() && applyButton.isEnabled();
    }
}
