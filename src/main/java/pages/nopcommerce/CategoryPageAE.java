package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(CategoryPageAE.class.getName());

    public CategoryPageAE(WebDriver driver) {
        super(driver);
    }

    // Web Elements (Page Objects)
    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    private WebElement categorySidebarElement;

    @FindBy(xpath = "//div[@class='left-sidebar']//a[contains(text(), 'Women')]")
    private WebElement womenCategoryBtn;

    @FindBy(xpath = "//div[@class='left-sidebar']//a[contains(text(), 'Men')]")
    private WebElement menCategoryBtn;

    @FindBy(xpath = "//div[@id='Women']//a[contains(text(), 'Dresses')]")
    private WebElement womenDressesBtn;

    @FindBy(xpath = "//div[@id='Men']//a[contains(text(), 'T-shirts')]")
    private WebElement menTshirtsBtn;

    @FindBy(xpath = "//div[@class='page-title']//h1")
    private WebElement pageHeader;

    // Reusable methods
    public String getCategorySidebarTextTitle() {
        String categorySidebarText = getElementText(categorySidebarElement);
        LOG.info("Category sidebar text title: " + categorySidebarText);
        return categorySidebarText;
    }

    public void clickOnWomenCategory() {
        clickOn(womenCategoryBtn);
        LOG.info("Clicked on Women category button successfully");
    }

    public void clickOnMenCategory() {
        clickOn(menCategoryBtn);
        LOG.info("Clicked on Men category button successfully");
    }

    public void clickOnWomenDresses() {
        clickOn(womenDressesBtn);
        LOG.info("Clicked on Women Dresses button successfully");
    }

    public void clickOnMenTshirts() {
        clickOn(menTshirtsBtn);
        LOG.info("Clicked on Men T-shirts button successfully");
    }

    public String getPageHeader() {
        String headerText = getElementText(pageHeader);
        LOG.info("Page header: " + headerText);
        return headerText;
    }
}
