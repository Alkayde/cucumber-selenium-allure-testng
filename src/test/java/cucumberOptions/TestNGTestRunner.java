package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinitions",
        plugin = {"html:target/cucumber.html", "json:target/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

//mvn clean test "-Dcucumber.filter.tags=@PlaceOrder or @LandingPage"
//mvn clean test -Dcucumber.filter.tags=@PlaceOrder
//mvn clean test -Dbrowser=edge