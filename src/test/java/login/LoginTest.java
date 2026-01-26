package login;

import base.BaseTest;
import org.testng.annotations.Test;
import page.products.ProductsPage;
import utils.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {

    @Test
    public void validatePositiveLogin() {
        loginPage.logIn(User.STANDARD_USER);
        var productsPage = new ProductsPage();
        assertThat("Validating 'Products' page loaded", productsPage.isPageLoaded(), is(true));
    }

    @Test
    public void validateNegativeLogin() {
        loginPage.logIn(User.INVALID_USER);
        assertThat("Validating 'Login' page is still loaded", loginPage.isPageLoaded(), is(true));

        var loginValidationError = loginPage.getLoginValidationError();
        assertThat(loginValidationError.isDisplayed(), is(true));
        assertThat(loginValidationError.getText(), is(equalTo("Epic sadface: Username and password do not match any user in this service")));
    }
}
