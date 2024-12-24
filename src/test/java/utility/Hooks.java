package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public class Hooks {
    @Before
    public void setup() {
        new BrowserDriver();  // Initialize BrowserDriver
        WebDriver driver = BrowserDriver.getDriver();
        driver.manage().window().maximize();
        driver.get(Config.base_url);
        System.out.println("Driver setup in Hooks: " + driver);
    }

    @After
    public void tearDown() {
        if (BrowserDriver.driver != null) {
            new BrowserDriver().close();
            System.out.println("Driver closed in Hooks.");
        }
    }
}
