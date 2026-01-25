package wait;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Config;
import utils.Properties;

import java.time.Duration;

@Slf4j
@UtilityClass
public class WaitProvider {

    public static FluentWait<WebDriver> getWait(WebDriver driver) {
        var timeout = parseLong(Config.getProperty(Properties.DEFAULT_TIMEOUT));
        var polling = parseLong(Config.getProperty(Properties.DEFAULT_POLLING));

        return getWait(driver, Duration.ofSeconds(timeout), Duration.ofSeconds(polling));
    }

    public static FluentWait<WebDriver> getWait(WebDriver driver, Duration timeout, Duration polling) {
        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class,
                        StaleElementReferenceException.class);
    }

    private static Long parseLong(String str) {
        log.info("Parsing long from string: {}", str);
        long parsedLong;
        try {
            parsedLong = Long.parseLong(str);
            log.info("Long number: {}, correctly parsed from string", parsedLong);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return parsedLong;
    }
}