package stepDefinition;

import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static utility.BrowserDriver.driver;

public class ResultPage {
    @Then("user should be redirected to homepage")
    public void data(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement resultContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/select")));

            String resultText = resultContainer.getText();
            System.out.println("Result Text: " + resultText);
            if (resultText != null) {
                System.out.println("Result text is displayed correctly.");
            } else {
                System.out.println("Result text is empty or not displayed.");
                Assert.fail("Result text is empty or not displayed.");
            }

        } catch (NoSuchElementException e) {
            System.out.println("Result container not found: " + e.getMessage());
            Assert.fail("Result container not found.");
        }
    }

}
