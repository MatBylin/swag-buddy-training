package login;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {

    @Test
    public void validatePositiveLogin() {
        assertThat(loginPage.getUserNameInput().isDisplayed(), is(true));
    }
}
