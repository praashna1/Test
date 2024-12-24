package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {
    public static WebDriver driver;
    private static boolean isInitialized = false;  //  to avoid reinitialization

    public BrowserDriver() {
        if (!isInitialized) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
            driver = new ChromeDriver(options);
            options.addArguments("--disable-web-security"); // Disable CORS for testing purposes
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36");


            driver.get(Config.base_url); //  from Config
            isInitialized = true;
            System.out.println("WebDriver initialized: " + driver);
        } else {
            System.out.println("WebDriver already initialized.");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized!");
        }
        return driver;
    }

    //    public static void switchTo() {
//    }
    public void close() {
        if (driver != null) {
            driver.quit();
            isInitialized = false;
        }
    }
}
