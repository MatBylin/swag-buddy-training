package page.login;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;
import utils.Config;
import utils.Properties;
import utils.User;

import java.util.Objects;

@Slf4j
@Getter
public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement loginValidationError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(User user) {
        log.info("Logging using: `%s` credentials".formatted(user));
        userNameInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
    }

    @Override
    public boolean isPageLoaded() {
        return Objects.requireNonNull(driver.getCurrentUrl()).equals(Config.getProperty(Properties.BASE_URL))
                && getUserNameInput().isDisplayed()
                && getPasswordInput().isDisplayed();
    }
}
