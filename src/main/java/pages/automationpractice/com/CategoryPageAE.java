package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(CategoryPageAE.class.getName());

    public CategoryPageAE(WebDriver driver) {
        super(driver);
    }

    //objects (web elements)
    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    WebElement categorySidebarElement;

    @FindBy(xpath = "//div[@class='left-sidebar']//a[@href='#Women']")
    WebElement womenCategoryBtn;

    @FindBy(xpath = "//div[@class='left-sidebar']//a[@href='#Men']")
    WebElement menCategoryBtn;

    @FindBy(xpath = "//div[@id='Women']//a[text()='Dress ']")
    WebElement womenDressBtn;

    @FindBy(xpath = "//div[@id='Men']//a[text()='Tshirts ']")
    WebElement menTshirtsBtn;

    @FindBy(xpath = "//div[@class='features_items']/h2")
    WebElement featuresItemsTitleElement;

    //reusable steps
    public String categorySidebarTextTitle(){
        String categorySidebarText = getElementText(categorySidebarElement);
        LOG.info("category sidebar text title: "+categorySidebarText);
        return categorySidebarText;
    }

    public void clickOnWomenCategory(){
        clickOn(womenCategoryBtn);
        LOG.info("click on women category button success");
    }

    public void clickOnMenCategory(){
        clickOn(menCategoryBtn);
        LOG.info("click on men category button success");
    }

    public void clickOnWomenDress(){
        clickOn(womenDressBtn);
        LOG.info("click on women dress button success");
    }

    public void clickOnMenTshirts(){
        clickOn(menTshirtsBtn);
        LOG.info("click on men tshirts button success");
    }

    public String verifyFeaturesItemsTitle(){
        String featuresItemsTitle = getElementText(featuresItemsTitleElement);
        LOG.info("features items text title: "+featuresItemsTitle);
        return featuresItemsTitle;
    }
}
