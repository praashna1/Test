package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignForm {
     static WebDriver driver;
    WebDriverWait wait;

    public SignForm(WebDriver driver) {
        SignForm.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
        public static String firstnamepath="//*[@id=\"fullname\"]";

    public static String emailpath="//*[@id=\"email\"]";
    public static String passwordpath="//*[@id=\"password\"]";

    public static String provincepath="//*[@id=\"state\"]";
    public static String tolepath="//*[@id=\"municipality\"]";
    public static String wardpath="//*[@id=\"ward\"]";
    public static  String locationpath="//*[@id=\"location\"]";

    public static String primaryContactpath="//*[@id=\"Primarycontact\"]";
    public static String secondaryContactpath="//*[@id=\"SEcondarycontact\"]";
    public static String button="//*[@id=\"root\"]/div[2]/form/button";


    public static void sendName(String username){
        driver.findElement(By.xpath(firstnamepath)).sendKeys(username.trim());
    }

    public static void sendEmail(String email){
        driver.findElement(By.xpath(emailpath)).sendKeys(email.trim());
    }
    public static void sendPassword(String password){
        driver.findElement(By.xpath(passwordpath)).sendKeys(password.trim());

    }
    public static void sendProvince(String province){
        driver.findElement(By.xpath(provincepath)).sendKeys(province.trim());
    }

    public static void sendTole(String tole){
        driver.findElement(By.xpath(tolepath)).sendKeys(tole.trim());
    }

    public static void sendWard(String ward){
        driver.findElement(By.xpath(wardpath)).sendKeys(ward.trim());
    }

    public static void sendLocation(String location){
        driver.findElement(By.xpath(locationpath)).sendKeys(location.trim());
    }

    public static void sendPrimary(String primary){
        driver.findElement(By.xpath(primaryContactpath)).sendKeys(primary.trim());
    }

    public static void sendSecond(String secondary){
        driver.findElement(By.xpath(secondaryContactpath)).sendKeys(secondary.trim());
    }

    public static void sendButton() {
        driver.findElement(By.xpath(button)).click();
    }

}
