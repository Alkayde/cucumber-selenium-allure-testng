package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    private WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindowToChild() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> windowHandlesIterator = windowHandles.iterator();
        String childWindow = windowHandlesIterator.next();

        driver.switchTo().window(childWindow);
    }
}
