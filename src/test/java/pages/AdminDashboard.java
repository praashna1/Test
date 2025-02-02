package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboard {
static WebDriver driver;
public AdminDashboard(WebDriver driver){
    this.driver=driver;
}
    public static String Aemail="exampleInputEmail1";
   public static  String Apass ="exampleInputPassword1";
    public static String Abutton="//*[@id=\"root\"]/div/form/button";

    public static String icon="//*[@id=\"root\"]/div/div[1]/nav/ul/li[1]";

    public static void Adminemail(){
        driver.findElement(By.id(Aemail)).sendKeys("Admin1@gmail.com");
    }
    public static void Adminpass(){
        driver.findElement(By.id(Apass)).sendKeys("Admin@123");
    }
    public static void  Adminbut(){
        driver.findElement(By.xpath(Abutton)).click();
    }
    public static void Adminicon(){
        driver.findElement(By.xpath(icon)).click();
    }
}
