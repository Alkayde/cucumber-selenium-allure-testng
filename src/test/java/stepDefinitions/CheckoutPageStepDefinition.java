package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("User gets to Checkout Page")
    public void userGetsToCheckoutPage() {
        Assert.assertTrue(testContextSetup.driverFactory.webDriverManager().getCurrentUrl().contains("cart"), "User is not on the checkout page");
    }

    @Then("Product added to cart are shown on Checkout Page")
    public void productAddedToCartAreShownOnCheckoutPage() {
        testContextSetup.checkoutPageProductName = checkoutPage.getProductName().split("-")[0].trim();
        Assert.assertEquals(testContextSetup.checkoutPageProductName, testContextSetup.landingPageProductName, "Product name added on landing page and product name displayed on the checkout page are not equal");
    }

    @Then("Product quantity on the Checkout Page is {int}")
    public void productQuantityOnTheCheckoutPageCorrespondsToTheQuantityOfProductAddedOnTheLandingPage(int quantity) {
        Assert.assertEquals(Integer.parseInt(checkoutPage.getQuantity()), quantity, "Quantity on the Checkout page does not correspond to quantity of the added to the cart products");
    }

    @Then("User is able to place the order")
    public void placeOrderButtonIsDisplayedAndActive() {
        Assert.assertTrue(checkoutPage.placeOrderButtonIsDisplayedAndActive(), "Place Order button is not displayed and/or active");
    }

    @And("User is able to apply promocode")
    public void applyButtonIsDisplayedAndActive() {
        Assert.assertTrue(checkoutPage.applyButtonIsDisplayedAndActive(), "Apply button is not displayed and/or acitve");
    }
}
