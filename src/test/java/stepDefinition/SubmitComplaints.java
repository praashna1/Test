package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ComplainForm;
import pages.Complaints;
import static pages.ComplainForm.*;
import java.time.Duration;
import static pages.Complaints.*;
import static utility.BrowserDriver.driver;
import static utility.Config.*;

public class SubmitComplaints {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    ComplainForm admin=new ComplainForm(driver);
    Complaints complaints=new Complaints(driver);
    @Given("^user enters valid login details")
    public void userIsLoggedIn() {
     driver.get(login_url);
        sendEmaill();
        sendPasswordd();
       sendButtonn();
    }

    @Given("user is in complain selection")
    public void userSelectsComplaintType() {
        WebElement resultContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[1]/div/select")));
        driver.get(complain_url);
        ClickType();
        ClickBut();
    }

    @When("user fills in the complaint form")
    public void userFillsComplaintForm() {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/form/div[1]/input")));
        driver.get(form_url);
        sendTitle();
        sendCategory();
        sendProvince("Bagmati","Kathmandu");
        sendTole();
        sendWard();
        sendDesc();
        sendFile("D:\\downloads\\ap.jpg");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//*[@id=\"root\"]/div/form/div[5]/div"),"1 file(s) attached"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", button);

        sendSubmit();
    }

    @Then("user should successfully submit complain")
    public void userShouldSeeConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            String currentUrl = driver.getCurrentUrl();
            boolean isRedirected = currentUrl.contains("localhost:3000/form");
            WebElement resultContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"root\"]/div/div[1]/div/select")));
            System.out.println("complain submitted");
        } catch (Exception e) {
            System.out.println("submission failed");
        }
    }

    }

