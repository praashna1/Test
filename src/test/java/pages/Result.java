package pages;

import org.openqa.selenium.By;

import static utility.BrowserDriver.driver;

public class Result {
    public static String result="//*[@id=\"root\"]/div[2]/div[1]/div/select";
    public static void Results(){
        driver.findElement(By.xpath(result)).click();
    }
}
