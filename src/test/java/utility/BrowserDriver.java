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
            driver.get("http://localhost:3000");
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
