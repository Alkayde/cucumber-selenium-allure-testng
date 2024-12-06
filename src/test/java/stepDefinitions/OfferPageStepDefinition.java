package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

    public TestContextSetup testContextSetup;
    public OffersPage offersPage;


    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.offersPage = testContextSetup.pageObjectManager.getOffersPage();
    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_the_same_shortname_in_offers_page(String shortName) {
        switchToOffersPage();
        offersPage.searchItem(shortName);
        testContextSetup.offerPageProductName = offersPage.getProductName();
    }

    private void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.navigateToOffersPage();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_Offer_Page() {
        Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.landingPageProductName, "Product name on the landing page and product name on the offer page are not equal");
    }


}
