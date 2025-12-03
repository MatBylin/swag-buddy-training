package login;

import base.BaseTest;
import driver.DriverProvider;
import lombok.val;
import org.testng.annotations.Test;
import page.products.ProductsPage;
import utils.Config;
import utils.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {

    @Test
    public void validatePositiveLogin() {
        assertThat(loginPage.getUserNameInput().isDisplayed(), is(true));

        val userName = Config.getProperty(Properties.STANDARD_USER_LOGIN);
        val userPassword = Config.getProperty(Properties.USER_PASSWORD);
        val expectedPageHeader = "Products";

        loginPage.logIn(userName, userPassword);
        val productsPage = new ProductsPage(DriverProvider.getWebDriver());
        assertThat(productsPage.getPageTitle().getText(), equalTo(expectedPageHeader));
    }
}
