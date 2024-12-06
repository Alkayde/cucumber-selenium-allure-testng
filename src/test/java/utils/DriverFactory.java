package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver webDriverManager() {
        if (driver == null) {
            Properties properties = new Properties();
            try (InputStream inputStream = DriverFactory.class.getClassLoader().getResourceAsStream("global.properties")) {
                properties.load(inputStream);
            } catch (IOException exception) {
                throw new RuntimeException(exception.getMessage());
            }

            String url = System.getProperty("url", properties.getProperty("QAUrl"));
            String browser = System.getProperty("browser", properties.getProperty("browser"));
            if (browser == null || url == null) {
                throw new IllegalArgumentException("Browser or QAUrl not specified in system properties or global.properties");
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.get(url);
        }
        return driver;
    }
}
