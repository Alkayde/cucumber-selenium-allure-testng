package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public OffersPage(WebDriver webDriver, WebDriverWait wait) {
        this.driver = webDriver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;
    @FindBy(css = "tr td:nth-child(1)")
    private WebElement offerPageProductName;

    public void searchItem(String name) {
        searchInput.sendKeys(name);
    }

    public String getProductName() {
        return offerPageProductName.getText();
    }
}
