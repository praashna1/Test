package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form {
    static WebDriver driver;
    WebDriverWait wait;
    public Form(WebDriver driver){
        Form.driver =driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public static String email="//*[@id=\"exampleInputEmail1\"]";
    public static String password="//*[@id=\"exampleInputPassword1\"]";
    public static String button="//*[@id=\"root\"]/div[2]/form/button";
    public static void sendEmail(String inputEmail) throws InterruptedException {
        driver.findElement(By.xpath(email)).sendKeys(inputEmail);
        Thread.sleep(100);
    }
    public static void sendPassword(String inputPassword){
        driver.findElement(By.xpath(password)).sendKeys(inputPassword);
    }
    public static void sendButton(){
        driver.findElement(By.xpath(button)).click();
    }
//    public static String firstname="//*[@id=\"fullname\"]";
//
//    public static String email="//*[@id=\"email\"]";
//    public static String password="//*[@id=\"password\"]";
//
//    public static String province="//*[@id=\"state\"]";
//    public static String tole="//*[@id=\"municipality\"]";
//    public static String ward="//*[@id=\"ward\"]";
//    public static  String location="//*[@id=\"location\"]";
//
//    public static String primaryContact="//*[@id=\"Primarycontact\"]";
//    public static String secondaryContact="//*[@id=\"SEcondarycontact\"]";
//    public static String button="//*[@id=\"root\"]/div[2]/form/button";
//
//
//    public static void sendName(){
//        driver.findElement(By.xpath(firstname)).sendKeys("hii");
//    }
//
//    public static void sendEmail(){
//        driver.findElement(By.xpath(email)).sendKeys("pp@12gmail.com");
//    }
//    public static void sendPassword(){
//        driver.findElement(By.xpath(password)).sendKeys("Hhh212");
//
//    }
//
//    public static void sendProvince(){
//        driver.findElement(By.xpath(province)).sendKeys("bagmati");
//    }
//
//    public static void sendTole(){
//        driver.findElement(By.xpath(tole)).sendKeys("shanti");
//    }
//
//    public static void sendWard(){
//        driver.findElement(By.xpath(ward)).sendKeys("3");
//    }
//
//    public static void sendLocation(){
//        driver.findElement(By.xpath(location)).sendKeys("ktm");
//    }
//
//    public static void sendPrimary(){
//        driver.findElement(By.xpath(primaryContact)).sendKeys("9800124572");
//    }
//
//    public static void sendSecond(){
//        driver.findElement(By.xpath(secondaryContact)).sendKeys("981234572");
//    }
//
//    public static void sendButton(){
//        driver.findElement(By.xpath(button)).click();
//    }
}
