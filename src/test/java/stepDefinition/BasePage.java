package stepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.Form;
import utility.BrowserDriver;

import static pages.Form.*;

public class BasePage {
    WebDriver driver= BrowserDriver.getDriver();
    Form form=new Form(driver);
    @Given("^user enters (.*) and (.*)$")
    public void data(String email, String password) throws InterruptedException{
       // sendName();
        sendEmail(email);
        sendPassword(password);
       // sendLocation();
       // sendProvince();
       // sendTole();
       // sendWard();
       // sendPrimary();
       // sendSecond();
        sendButton();
    }
}
