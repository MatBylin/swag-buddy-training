package login;

import base.BaseTest;
import driver.DriverProvider;
import org.testng.annotations.Test;
import page.products.ProductsPage;
import utils.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {

    @Test
    public void validatePositiveLogin() {
        var user = User.STANDARD_USER;

        loginPage.logIn(user.getLogin(), user.getPassword());
        var productsPage = new ProductsPage(DriverProvider.getWebDriver());
        assertThat(productsPage.isPageLoaded(), is(true));
    }
}
