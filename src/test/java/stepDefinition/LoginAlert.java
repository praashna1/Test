//package stepDefinition;
//
//import io.cucumber.java.en.When;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//import static utility.BrowserDriver.driver;
//
//public class LoginAlert {
////    @When("user successfully passes data")
////    public void data() {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////        try {
////            if (isAlertPresent(wait)) {
////                Alert alert = driver.switchTo().alert(); // Switch to the alert box
////                String alertText = alert.getText(); // Get the text from the alert box
////
////                System.out.println("Alert Message: " + alertText);
////                alert.accept();
////                ResultPage.setFlag("N"); //alert means failure
////            } else {
////                System.out.println("No alert present: Login succeeded."); //no alert means success
////                ResultPage.setFlag("Y");
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            throw new RuntimeException("An unexpected error occurred while handling alerts.", e);
////        }
////    }
////    private boolean isAlertPresent(WebDriverWait wait) {
////        try {
////            wait.until(ExpectedConditions.alertIsPresent());
////            return true; // Alert is present
////        } catch (TimeoutException e) {
////            return false; // No alert is present
////        }
////    }
////}
