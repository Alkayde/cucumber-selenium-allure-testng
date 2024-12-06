package utils;

import pageObjects.PageObjectManager;

public class TestContextSetup {

    public String landingPageProductName;
    public String cartPreviewProductName;
    public String offerPageProductName;
    public String checkoutPageProductName;
    public PageObjectManager pageObjectManager;
    public DriverFactory driverFactory;
    public GenericUtils genericUtils;

    public TestContextSetup() {
        driverFactory = new DriverFactory();
        pageObjectManager = new PageObjectManager(driverFactory.webDriverManager());
        genericUtils = new GenericUtils(driverFactory.webDriverManager());

    }
}
