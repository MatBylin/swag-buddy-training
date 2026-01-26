package base;

import driver.DriverProvider;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.login.LoginPage;
import utils.Config;
import utils.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class BaseTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = DriverProvider.getWebDriver();
        openLoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing browser");
        DriverProvider.removeWebDriver();
    }

    private void openLoginPage(WebDriver driver) {
        var baseUrl = Config.getProperty(Properties.BASE_URL);
        log.info("Opening logging page: {}", baseUrl);
        driver.get(baseUrl);
        loginPage = new LoginPage();
        assertThat(loginPage.isPageLoaded(), is(true));
    }
}
