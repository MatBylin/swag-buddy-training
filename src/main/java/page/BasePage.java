package page;

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

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = WaitProvider.getWait(driver);
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        log.info("Clicking the element.");
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        log.info("Sending keys: '{}' to the element", text);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public abstract boolean isPageLoaded();
}
