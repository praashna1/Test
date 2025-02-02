package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AdminUsers {
    static WebDriver driver;
    public AdminUsers(WebDriver driver){

        this.driver=driver;
    }

    public static String search="//*[@id=\"root\"]/div/div[2]/div/div/input";

    public static String view="//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[4]";

    public static String userData="//*[@id=\"root\"]/div/div[2]/div";

    public static void ClickSearch(){
        driver.findElement(By.xpath(search)).sendKeys("isha");
    }
    public static void ClickView() {
        driver.findElement(By.xpath(view)).click();
    }
    public static  void ClickData(){
        driver.findElement(By.xpath(userData));
    }




}
