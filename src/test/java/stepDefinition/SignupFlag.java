package stepDefinition;

import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static utility.BrowserDriver.driver;
import utility.DatabaseHelper;

public class SignupFlag {
    @Then("user should be in otp page with (.*) and (.*)$")
    public void data(String flag, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            String currentUrl = driver.getCurrentUrl();
            boolean isRedirected = currentUrl.contains("localhost:3000/otp");

            String otp = utility.DatabaseHelper.fetch(email);
            System.out.println("Fetched OTP for email " + email + ": " + otp);
         //   WebElement resultContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
             //       By.xpath("//*[@id=\"root\"]/div[2]/form/button"))); //otp submit button
//            String resultText = resultContainer.getText();
//            System.out.println("Result Text: " + resultText);
//            if (resultText != null) {
//                System.out.println("Result text is displayed correctly.");
//            } else {
//                System.out.println("Result text is empty or not displayed.");
//                Assert.fail("Result text is empty or not displayed.");
//            }
//
//        } catch (NoSuchElementException e) {
//            System.out.println("Result container not found: " + e.getMessage());
//            Assert.fail("Result container not found.");
//        }
//    }
            if (flag.equalsIgnoreCase("Y")) {
                Assert.assertTrue(isRedirected, "Expected to be redirected, but was not."); //if fails shows this
                System.out.println("Signin succeeded as expected.");
            } else if (flag.equalsIgnoreCase("N")) {
                Assert.assertFalse(isRedirected, "Expected signin to fail, but it succeeded."); //if passes shows this
                System.out.println("Signin failed as expected.");
            }
        } catch (Exception e) {
            if (flag.equalsIgnoreCase("N")) {
                System.out.println("Signin failed as expected.");
            } else {
                throw new AssertionError("Login succeeded unexpectedly or an error occurred.", e);
            }
        }
    }}

