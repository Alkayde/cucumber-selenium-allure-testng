package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectManager {

    private WebDriver driver;
    private LandingPage landingPage;
    private OffersPage offersPage;
    private CheckoutPage checkoutPage;
    private WebDriverWait wait;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public LandingPage getLandingPage() {
        return landingPage == null ? new LandingPage(driver, wait) : landingPage;
    }

    public OffersPage getOffersPage() {
        return offersPage == null ? new OffersPage(driver, wait) : offersPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage == null ? new CheckoutPage(driver, wait) : checkoutPage;
    }
}
