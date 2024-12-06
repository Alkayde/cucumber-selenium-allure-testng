package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public LandingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;
    @FindBy(css = "h4.product-name")
    private WebElement productName;
    @FindBy(linkText = "Top Deals")
    private WebElement topDeals;
    @FindBy(css = "a.increment")
    private WebElement incrementProduct;
    @FindBy(xpath = "//button[text()='ADD TO CART']")
    private WebElement addToCart;
    @FindBy(css = "a.cart-icon")
    private WebElement cartIcon;
    @FindBy(css = "div.cart-preview.active")
    private WebElement cartPreview;
    @FindBy(xpath = "//div[@class='cart-preview active']//p[@class='product-name']")
    private WebElement cartPreviewProductName;
    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    private WebElement proceedToCheckoutButton;


    public void searchItem(String name) {
        searchInput.sendKeys(name);
        wait.until(ExpectedConditions.textToBePresentInElement(productName, name));
    }

    public String getProductName() {
        return productName.getText();
    }

    public void navigateToOffersPage() {
        topDeals.click();
    }

    public void clickOnIncrementProduct(int quantityOfClicks) {
        wait.until(ExpectedConditions.elementToBeClickable(incrementProduct));
        for (int i = 0; i < quantityOfClicks; i++) {
            incrementProduct.click();
        }
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
        wait.until(ExpectedConditions.visibilityOf(cartPreview));
    }

    public WebElement getCartPreview() {
        return cartPreview;
    }

    public String getCartPreviewProductName() {
        return cartPreviewProductName.getText();
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        wait.until(ExpectedConditions.invisibilityOf(proceedToCheckoutButton));
        System.out.println("Timeout set: " + driver.manage().timeouts().getImplicitWaitTimeout().getSeconds());
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

}
