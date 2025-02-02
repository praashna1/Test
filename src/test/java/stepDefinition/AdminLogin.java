package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminDashboard;
import utility.BrowserDriver;

import java.time.Duration;

import static pages.AdminDashboard.*;
import static utility.Config.*;

public class AdminLogin {
    WebDriver driver= BrowserDriver.getDriver();
    AdminDashboard dashboard= new AdminDashboard(driver);

    @Given("admin is in login page")
    public void admin(){
        driver.get(admin_url);

    }

    @When("admin enters email and password")
    public void success(){
        driver.get(admin_url);
        try {
            Adminemail();
            Adminpass();
            Adminbut();
            System.out.println("login passed");
        }catch (Exception e){
            System.out.println("login failed");
        }

    }

    @Then("admin should be in dashboard")
    public void homepage() throws InterruptedException {
        Thread.sleep(100);
//        driver.get(dashboard_url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Thread.sleep(10);
        //Adminicon();
        WebElement resultContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]")));

    }
}
