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
    @Given("^user enters (.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
    public void data(String username, String email, String password, String confirm, String ward, String tole, String primary) throws InterruptedException {
        driver.get(signup_url);
         sendName(username);
         sendEmail(email);
        sendPassword(password);
        sendConfirm(confirm);
        selectState("Bagmati","Kathmandu");
        sendWard(ward);
        sendTole(tole);

        sendPrimary(primary);
        //sendSecond(secondary);

        sendButton();


    }
}
