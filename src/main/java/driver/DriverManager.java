package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static WebDriver getDriver() {
        return new ChromeDriver(getChromeOptions());
    }

    private static ChromeOptions getChromeOptions() {
        var chromeOptions = new ChromeOptions();

        var remoteRun = Boolean.parseBoolean(
                System.getProperty("headless", "false")
        );

        if (remoteRun) {
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
        }

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--aggressive-cache-discard");
        return chromeOptions;
    }
}
