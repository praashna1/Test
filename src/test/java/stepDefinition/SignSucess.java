package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utility.BrowserDriver.driver;

public class SignSucess {
    @When("user submits the sign-up form")
    public void data() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();

            String alertText = alert.getText();
            System.out.println("Alert Message: " + alertText);
            alert.accept(); 

        } catch (NoAlertPresentException e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }

}
