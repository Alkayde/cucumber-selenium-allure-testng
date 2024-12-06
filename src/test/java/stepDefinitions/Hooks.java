package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.TestContextSetup;

public class Hooks {

    private TestContextSetup testContextSetup;
    private WebDriver driver;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.driver = testContextSetup.driverFactory.webDriverManager();
    }

    @After
    public void afterScenario(Scenario scenario) {
        updateFixtureName("After scenario cleanup");
        if (scenario.isFailed()) {
            byte[] screenshotOnFail = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotOnFail, "image/png", "Failure Screenshot");
        }
        System.out.println("quitting browser");
        driver.quit();
    }

    private static void updateFixtureName(String name) {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.updateFixture(fixtureResult -> fixtureResult.setName(name));
    }
}
