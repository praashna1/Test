package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminComplain;
import pages.AdminDashboard;
import pages.AdminUsers;
import utility.BrowserDriver;

import java.time.Duration;
import java.util.List;

import static pages.AdminDashboard.*;
import static utility.Config.*;

public class AdminComp {
    WebDriver driver= BrowserDriver.getDriver();
    AdminDashboard dashboard= new AdminDashboard(driver);
    AdminUsers user=new AdminUsers(driver);
    AdminComplain complain=new AdminComplain(driver);

    @Given("admin enter email and password and is in dashboard")
    public void adEnter(){
        driver.get(admin_url);
        Adminemail();
        Adminpass();
        Adminbut();
        System.out.println("login successful");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement dashboardIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]")));
            dashboardIcon.click();
            System.out.println("homepage icon located");
        }catch(Exception e) {
            System.out.println("homepage icon not located");

        }
    }
    @When("admin is in complaint management board")
    public void adComplain() {
        driver.get(comp_url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement complaintContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div/table")));
        complaintContainer.click();
        List<WebElement> complaintCards = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/table"));
        for (WebElement row : complaintCards) {
            String complaint = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/table/tbody/tr[1]")).getText();
//            String category = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/table/tbody/tr[1]")).getText();
//            String location = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/table/tbody/tr[1]")).getText();

            System.out.println("Complaint: " + complaint);
            try{
            WebElement eyeIcon = row.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/table/tbody/tr[1]/td[8]/button"));
            eyeIcon.click();
                System.out.println("clicked");
        }catch(Exception e){
                System.out.println("lala");
        }
    }}
    @Then("admin sees details")
    public void adDetail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement specificComplain = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/table")));
        specificComplain.click();
        try{
            //get the details of the complaint
            List<WebElement> complaintDetails=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/table"));
            for (WebElement rows : complaintDetails) {
                String complaints = rows.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody")).getText();
                System.out.println("Complaint: " + complaints); }
            }catch(Exception e){
            System.out.println("noo");
        }

    }
}
