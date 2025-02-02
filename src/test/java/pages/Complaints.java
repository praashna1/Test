package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Complaints {
 static WebDriver driver;
     static WebDriverWait wait;

    public Complaints(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static String Title="//*[@id=\"root\"]/div/form/div[1]/input";

    public static String Category="//*[@id=\"root\"]/div/form/div[2]/input";

    public static String Province="//*[@id=\"root\"]/div/form/div[3]/div/select[1]";
    public static String ProvinceSelect="//*[@id=\"root\"]/div/form/div[3]/div/select[1]/option[4]";
    public static String District="//*[@id=\"root\"]/div/form/div[3]/div/select[2]";
    public static  String DistrictSelect="//*[@id=\"root\"]/div/form/div[3]/div/select[2]/option[6]";
    public static String Ward="//*[@id=\"root\"]/div/form/div[3]/input[2]";
    public static String Tole="//*[@id=\"root\"]/div/form/div[3]/input[1]";
    public static String Descrip="//*[@id=\"root\"]/div/form/div[4]/textarea";
    public static String File="//*[@id=\"root\"]/div/form/div[5]/input";
    public static String Submit="//*[@id=\"root\"]/div/form/button";
    public static String SubmitReload="//*[@id=\"root\"]/div/form/div[5]/div/p";

    public static void sendTitle(){
        driver.findElement(By.xpath(Title)).sendKeys("flood");
    }
    public static void sendCategory(){
        driver.findElement(By.xpath(Category));
    }
    public static void sendProvince(String ProvinceName, String DistrictName){
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

    public static void sendWard(){
        driver.findElement(By.xpath(Tole)).sendKeys("shanti");
    }
    public static void sendTole(){
        driver.findElement(By.xpath(Ward)).sendKeys("4");
    }
    public static void sendDesc(){
        driver.findElement(By.xpath(Descrip)).sendKeys("hhshdhdg");
    }
    public static void sendFile(String file){
        WebElement fileInput=driver.findElement(By.xpath(File));
        fileInput.sendKeys("D:\\downloads\\ap.jpg");
    }
    public static void sendSubmit(){
        driver.findElement(By.xpath(Submit)).click();
    }
}
