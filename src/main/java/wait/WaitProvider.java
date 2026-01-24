package wait;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Config;
import utils.Properties;

import java.time.Duration;

@UtilityClass
public class WaitProvider {

    public static FluentWait<WebDriver> getWait(WebDriver driver) {
        var timeout = Duration.ofSeconds(Long.getLong(Config.getProperty(Properties.DEFAULT_TIMEOUT)));
        var polling = Duration.ofSeconds(Long.getLong(Config.getProperty(Properties.DEFAULT_POLLING)));

        return getWait(driver, timeout, polling);
    }

    public static FluentWait<WebDriver> getWait(WebDriver driver, Duration timeout, Duration polling) {
        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class,
                        StaleElementReferenceException.class);
    }

}
