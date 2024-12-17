package stepDefinition;

import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utility.BrowserDriver.driver;

public class Submit {
@When("user successfully passes data")
public void data() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert box
        Alert alert = driver.switchTo().alert();

        // Get the text from the alert box
        String alertText = alert.getText();
        System.out.println("Alert Message: " + alertText);

        // Accept the alert (click OK)
        alert.accept();

    } catch (NoAlertPresentException e) {
        System.out.println("No alert present: " + e.getMessage());
    }
}
}
