package page.login;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import utils.Config;
import utils.Properties;

import java.util.Objects;

@Getter
public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement wrongLoginValidationMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void fillUserName(String username) {
        userNameInput.sendKeys(username);
    }

    private void fillPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void logIn(String username, String password) {
        fillUserName(username);
        fillPassword(password);
        loginButton.click();
    }

    public boolean isPageLoaded() {
        return Objects.requireNonNull(driver.getCurrentUrl()).equals(Config.getProperty(Properties.BASE_URL))
                && getUserNameInput().isDisplayed()
                && getPasswordInput().isDisplayed();
    }
}
