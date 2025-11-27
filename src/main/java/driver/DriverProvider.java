package driver;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;

@UtilityClass
public class DriverProvider {

    private static final ThreadLocal<WebDriver> DRIVER = ThreadLocal.withInitial(DriverProvider::createInstance);

    public static WebDriver getWebDriver() {
        return DRIVER.get();
    }

    public static void removeWebDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }

    private static WebDriver createInstance() {
        WebDriver driver = DriverManager.getDriver();
        maximizeBrowser(driver);

        return driver;
    }

    private static void maximizeBrowser(WebDriver driver) {
        driver.manage()
                .window()
                .maximize();
    }
}
