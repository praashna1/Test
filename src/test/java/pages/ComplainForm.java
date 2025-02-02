package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComplainForm {

      static WebDriver driver;
      static WebDriverWait wait;
    public ComplainForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public static String Type="//*[@id=\"root\"]/div/div[1]/div/select";

    public static String Dropdown="//*[@id=\"root\"]/div/div[1]/div/select/option[2]";
    public static String Button="//*[@id=\"root\"]/div/div[1]/button";

    public static String emailLocate = "//*[@id=\"exampleInputEmail1\"]";
    public static String passwordLocate = "//*[@id=\"exampleInputPassword1\"]";
    public static String button = "//*[@id=\"root\"]/div/form/button";

    public static void sendEmaill() {
        driver.findElement(By.xpath(emailLocate)).sendKeys("ishabhatta41@gmail.com");
        //Thread.sleep(100);
    }

    public static void sendPasswordd() {
        driver.findElement(By.xpath(passwordLocate)).sendKeys("Isha@1234");
    }

    public static void sendButtonn() {
        driver.findElement(By.xpath(button)).click();
    }

    public static void ClickType(){
        WebElement typeDropdown = driver.findElement(By.xpath(Type));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeDropdown);
        typeDropdown.click();
        WebElement stateOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dropdown)));
        stateOption.click();
    }
    public static void ClickBut(){
        driver.findElement(By.xpath(Button)).click();
    }
}
