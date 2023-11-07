package pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(CartPageAE.class.getName());

    public CartPageAE(WebDriver driver) {
        super(driver);
    }

    // Web Elements (Page Objects)
    @FindBy(xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitleElement;

    @FindBy(xpath = "//a[text()='Checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='header-logo']//a")
    private WebElement logo;

    // Reusable methods
    public String getCartPageTitle() {
        String title = getElementText(pageTitleElement);
        LOG.info("Cart page title: " + title);
        return title;
    }

    public void clickCheckoutButton() {
        clickOn(checkoutButton);
        LOG.info("Clicked on Checkout button successfully");
    }

    public void clickLogo() {
        clickOn(logo);
        LOG.info("Clicked on the logo successfully");
    }
}
