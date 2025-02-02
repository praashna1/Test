package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AdminDashboard;
import pages.AdminUsers;
import utility.BrowserDriver;
import java.time.Duration;
import java.util.List;

import static pages.AdminDashboard.*;
import static pages.AdminUsers.*;
import static utility.Config.*;

public class AdminUser {
    WebDriver driver= BrowserDriver.getDriver();
    AdminDashboard dashboard= new AdminDashboard(driver);
    AdminUsers user=new AdminUsers(driver);

    @Given("admin enter email and password")
    public void admin(){
        driver.get(admin_url);
        Adminemail();
        Adminpass();
        Adminbut();
    }
    @Given("admin is in dashboard")
    public void dash(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[1]/nav/ul/li[1]")));
        dashboardIcon.click();

    }
    @When("admin is in user management")
    public void user(){
        driver.get(user_url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ClickSearch();
        WebElement userContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody")));
        userContainer.click();

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table"));
        for (WebElement row : rows) {
            String userName = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[2]")).getText();
            String userId = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[3]")).getText();
            System.out.println("User: " + userName + ", Id: " + userId);
            Assert.assertEquals(userName, "isha");
            Assert.assertEquals(userId, "63");
            try{
                WebElement eyeIcon = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/button"));
                eyeIcon.click();
                System.out.println("clicked");
            }catch(Exception e){
                System.out.println("not clicked");
            }
        }
//        List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/input"));
//        for (WebElement row : results) {
//            String userName = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/thead/tr/th[2]")).getText();
//            Assert.assertTrue(userName.contains("User"), "Search result validation failed!");
//        }

    }
    @Then("admin should see user data")
    public void complaints(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement specificUser = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div")));
        specificUser.click();

        try{
            //locating inside tableof specific user
            List<WebElement> userDetails=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div"));
            for (WebElement rows : userDetails) {
                String user = rows.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/table/tbody")).getText();
                System.out.println("User: " + user); }
        }catch(Exception e){
            System.out.println("not displayed");
        }
        }


    }


