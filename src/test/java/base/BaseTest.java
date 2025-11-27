package base;

import driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.login.LoginPage;
import utils.Config;
import utils.Properties;

public class BaseTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = DriverProvider.getWebDriver();
        openLoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverProvider.removeWebDriver();
    }

    private void openLoginPage(WebDriver driver) {
        driver.get(Config.getProperty(Properties.BASE_URL));
        loginPage = new LoginPage(driver);
    }
}
