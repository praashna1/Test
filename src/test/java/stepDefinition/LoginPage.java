package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginForm;
import utility.BrowserDriver;

import java.time.Duration;

import static pages.LoginForm.*;
import static utility.BrowserDriver.driver;
import static utility.Config.login_url;

public class LoginPage {
    WebDriver driver= BrowserDriver.getDriver();
    LoginForm form=new LoginForm(driver);

    @Given("^user enters (.*) and (.*)$")
    public void data(String email, String password) throws InterruptedException{
        driver.get(login_url);
       sendEmail(email);
        sendPassword(password);
        sendButton();
    }
    @When("user successfully passes data")
    public void data() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            LoginPage ResultPage = null;
            if (isAlertPresent(wait)) {
                Alert alert = driver.switchTo().alert(); // Switch to the alert box
                String alertText = alert.getText(); // Get the text from the alert box

                System.out.println("Alert Message: " + alertText);
                alert.accept();
                ResultPage.setFlag("N"); //alert means failure
            } else {
                System.out.println("No alert present: Login succeeded."); //no alert means success
                ResultPage.setFlag("Y");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An unexpected error occurred while handling alerts.", e);
        }
    }
    private boolean isAlertPresent(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true; // Alert is present
        } catch (TimeoutException e) {
            return false; // No alert is present
        }
    }
    private static String flag;
    public static void setFlag(String status) {
        flag = status;
    }
    @Then("user should be redirected to homepage with flag (.*)$")
    public void data(String flag){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            String currentUrl = driver.getCurrentUrl();
            boolean isRedirected = currentUrl.contains("localhost:3000/complain");
            //   String resultText = resultContainer.getText();
            WebElement resultContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"root\"]/div/div[1]/button")));
            if (flag.equalsIgnoreCase("Y")) {
                Assert.assertTrue(isRedirected, "Expected to be redirected, but was not."); //if fails shows this
                System.out.println("Login succeeded as expected.");
            } else if (flag.equalsIgnoreCase("N")) {
                Assert.assertFalse(isRedirected, "Expected login to fail, but it succeeded."); //if passes shows this
                System.out.println("Login failed as expected.");
            }
        } catch (Exception e) {
            if (flag.equalsIgnoreCase("N")) {
                System.out.println("Login failed as expected.");
            } else {
                throw new AssertionError("Login succeeded unexpectedly or an error occurred.", e);
            }
        }

    }
}

