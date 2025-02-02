package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignForm {
     static WebDriver driver;
    static WebDriverWait wait;

    public SignForm(WebDriver driver) {
        SignForm.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    public static String firstnamepath="//*[@id=\"root\"]/div/form/div[1]/input";

    public static String emailpath="//*[@id=\"root\"]/div/form/div[2]/input";
    public static String passwordpath="//*[@id=\"root\"]/div/form/div[3]/input";
    public static  String Confirmpath="//*[@id=\"root\"]/div/form/div[4]/input";
    public static String Province="//*[@id=\"root\"]/div/form/div[6]/select";
    public static String ProvinceSelect="//*[@id=\"root\"]/div/form/div[6]/select/option[4]";
    public static String District="//*[@id=\"root\"]/div/form/div[7]/select";
    public static  String DistrictSelect="//*[@id=\"root\"]/div/form/div[7]/select/option[6]";
    public static String tolepath="//*[@id=\"root\"]/div/form/div[8]/input";
    public static String wardpath="//*[@id=\"root\"]/div/form/div[9]/input";

    public static String primaryContactpath="//*[@id=\"root\"]/div/form/div[5]/input";
   // public static String secondaryContactpath="//*[@id=\"SEcondarycontact\"]";
    public static String button="//*[@id=\"root\"]/div/form/button";


    public static void sendName(String username){
        driver.findElement(By.xpath(firstnamepath)).sendKeys(username.trim());
    }

    public static void sendEmail(String email){
        driver.findElement(By.xpath(emailpath)).sendKeys(email.trim());
    }
    private static String storedPassword;

    public static void sendPassword(String password) {
        storedPassword = password.trim();
        driver.findElement(By.xpath(passwordpath)).sendKeys(storedPassword.trim());
    }

    public static void sendConfirm(String confirm) {
        if (confirm.trim().equals(storedPassword)) {
            driver.findElement(By.xpath(Confirmpath)).sendKeys(confirm.trim());
        } else {
            throw new AssertionError("Password and Confirm Password do not match: " +
                    "Password='" + storedPassword + "', Confirm='" + confirm.trim() + "'");
        }
    }
    public static void sendWard(String ward){
        driver.findElement(By.xpath(tolepath)).sendKeys(ward.trim());
    }
    public static void sendTole(String tole){
        driver.findElement(By.xpath(wardpath)).sendKeys(tole.trim());
    }



    public static void sendPrimary(String primary){
        driver.findElement(By.xpath(primaryContactpath)).sendKeys(primary.trim());
    }

    public static void selectState(String ProvinceName, String DistrictName){
        WebElement provinceDropdown = driver.findElement(By.xpath(Province));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", provinceDropdown);
        provinceDropdown.click();
        // Select the province
        String provinceOptionXPath = ProvinceSelect + "[text()='" + ProvinceName + "']";
        WebElement stateOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(provinceOptionXPath)
        ));
        stateOption.click();
        //select specific distrcit
        WebElement districtDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(District)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", provinceDropdown);
        districtDropdown.click();

        // Select the specific district by its name
        String districtOptionXPath = DistrictSelect + "[text()='" + DistrictName + "']";
        WebElement cityOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(districtOptionXPath)
        ));
        cityOption.click();
    }

    public static void sendButton() {
        driver.findElement(By.xpath(button)).click();
    }


    }
