package page.products;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.Objects;

@Getter
public class ProductsPage extends BasePage {
    private static final String PAGE_PATH = "/inventory.html";
    private static final String PAGE_HEADER = "Products";

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement pageTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return Objects.requireNonNull(driver.getCurrentUrl()).endsWith(PAGE_PATH) && getPageTitle().getText().equals(PAGE_HEADER);
    }
}