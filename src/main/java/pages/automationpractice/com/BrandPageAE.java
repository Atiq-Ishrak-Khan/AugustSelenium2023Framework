package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(BrandPageAE.class.getName());

    public BrandPageAE(WebDriver driver) {
        super(driver);
    }

    //objects (web elements)
    @FindBy(xpath = "//div[@class='brands_products']/h2")
    WebElement brandSidebarElement;

    @FindBy(xpath = "//li//a[text()='Polo']")
    WebElement poloBrandBtn;

    @FindBy(xpath = "//li//a[text()='Babyhug']")
    WebElement BabyHugBrandBtn;

    @FindBy(xpath = "//div[@class='features_items']/h2")
    WebElement featuresItemsTitleElement;

    //reusable steps
    public String brandSidebarTextTitle(){
        String brandSidebarText = getElementText(brandSidebarElement);
        LOG.info("brands sidebar text title: "+brandSidebarText);
        return brandSidebarText;
    }

    public void clickOnPoloBrand(){
        clickOn(poloBrandBtn);
        LOG.info("click on polo brand button success");
    }

    public void clickOnBabyHugBrand(){
        clickOn(BabyHugBrandBtn);
        LOG.info("click on BabyHug brand button success");
    }

    public void verifyBrandPage(){
        String brandPageTitleText = getElementText(featuresItemsTitleElement);

        if (brandPageTitleText.contains("brand")){
            LOG.info("user is navigated to brand page success");
        } else {
            LOG.info("user is failed navigated to brand page");
        }
    }
}
