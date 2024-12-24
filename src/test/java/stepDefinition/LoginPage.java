package stepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LoginForm;
import utility.BrowserDriver;
import static pages.LoginForm.*;
import static utility.Config.login_url;

public class LoginPage {
    WebDriver driver= BrowserDriver.getDriver();
    LoginForm form=new LoginForm(driver);
    @Given("^user enters (.*) and (.*)$")
    public void data(String email, String password) throws InterruptedException{
        driver.get(login_url);

        sendEmail(email);
        sendPassword(password);
        sendButton();
    }
}
