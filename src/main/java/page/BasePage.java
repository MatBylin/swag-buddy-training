package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import wait.WaitProvider;

public abstract class BasePage {
    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = WaitProvider.getWait(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isPageLoaded();
}
