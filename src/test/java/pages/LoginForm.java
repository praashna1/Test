package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginForm {
    static WebDriver driver;
    WebDriverWait wait;

    public LoginForm(WebDriver driver) {
        LoginForm.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    public static String emailLocate = "//*[@id=\"exampleInputEmail1\"]";
    public static String passwordLocate = "//*[@id=\"exampleInputPassword1\"]";
    public static String button = "//*[@id=\"root\"]/div/form/button";

    public static void sendEmail(String email) {
        driver.findElement(By.xpath(emailLocate)).sendKeys(email);
        //Thread.sleep(100);
    }

    public static void sendPassword(String password) {
        driver.findElement(By.xpath(passwordLocate)).sendKeys(password);
    }

    public static void sendButton() {
        driver.findElement(By.xpath(button)).click();
    }
}
