package page;

import driver.DriverProvider;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import wait.WaitProvider;

@Slf4j
public abstract class BasePage {
    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public BasePage() {
        this.driver = DriverProvider.getWebDriver();
        this.wait = WaitProvider.getWait();
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        log.info("Clicking the element.");
        waitUntilElementToBeClickable(element);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        log.info("Sending keys: '{}' to the element", text);
        waitUntilVisibilityOf(element);
        element.sendKeys(text);
    }

    private void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitUntilVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public abstract boolean isPageLoaded();
}
