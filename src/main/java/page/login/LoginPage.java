package page.login;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

@Getter
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

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
}
