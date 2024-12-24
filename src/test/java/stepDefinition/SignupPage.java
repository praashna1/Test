package stepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.SignForm;
import utility.BrowserDriver;
import static pages.SignForm.*;
import static utility.Config.signup_url;

public class SignupPage {
    WebDriver driver= BrowserDriver.getDriver();
    SignForm form=new SignForm(driver);
    @Given("^user enters (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
    public void data(String username, String email, String password, String province, String ward, String tole, String location,  String primary, String secondary) throws InterruptedException {
        driver.get(signup_url);
         sendName(username);
        Thread.sleep(100);
         sendEmail(email);
        Thread.sleep(100);
        sendPassword(password);
        Thread.sleep(100);
        sendLocation(location);
        Thread.sleep(100);
        sendProvince(province);
        Thread.sleep(100);
        sendTole(tole);
        Thread.sleep(100);
        sendWard(ward);
        Thread.sleep(100);
        sendPrimary(primary);
        Thread.sleep(100);
        sendSecond(secondary);
        Thread.sleep(100);
        sendButton();

        Thread.sleep(100);
    }
}
