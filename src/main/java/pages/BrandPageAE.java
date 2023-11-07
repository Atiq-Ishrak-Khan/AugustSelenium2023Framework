package pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandPageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(BrandPageAE.class.getName());

    public BrandPageAE(WebDriver driver) {
        super(driver);
    }

    // Web Elements (Page Objects)
    @FindBy(xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitleElement;

    @FindBy(xpath = "//ul[@class='top-menu']//a[text()='Brands']")
    private WebElement brandsLink;

    @FindBy(xpath = "//h2[text()='Brands']")
    private WebElement brandsTitleElement;

    // Reusable methods
    public String getPageTitle() {
        String title = getElementText(pageTitleElement);
        LOG.info("Page title: " + title);
        return title;
    }

    public void clickBrandsLink() {
        clickOn(brandsLink);
        LOG.info("Clicked on the Brands link successfully");
    }

    public String getBrandsTitle() {
        String brandsTitle = getElementText(brandsTitleElement);
        LOG.info("Brands title: " + brandsTitle);
        return brandsTitle;
    }
}
