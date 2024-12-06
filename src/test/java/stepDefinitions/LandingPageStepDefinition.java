package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenKart Landing Page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        landingPage.searchItem(shortName);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
    }

    @When("User added the product to cart {int} times")
    public void userAddedTheProductToCart(int quantity) {
        landingPage.clickOnIncrementProduct(quantity);
        landingPage.addToCart();
    }

    @When("User clicked on cart icon")
    public void userClickedOnCartIcon() {
        landingPage.clickOnCartIcon();
    }

    @Then("Cart preview is shown")
    public void cartPreviewIsShown() {
        Assert.assertTrue(landingPage.getCartPreview().isDisplayed(), "Cart is not displayed");
    }

    @Then("Cart preview contains the product")
    public void cartPreviewContainsTheProduct() {
        testContextSetup.cartPreviewProductName = landingPage.getCartPreviewProductName().split("-")[0].trim();
        Assert.assertEquals(testContextSetup.cartPreviewProductName, testContextSetup.landingPageProductName, "Product name added on the landing page and product name in the cart are not equal");
    }

    @And("User proceeded to checkout")
    public void userClickedOnButton() {
        landingPage.clickOnProceedToCheckoutButton();
    }
}
