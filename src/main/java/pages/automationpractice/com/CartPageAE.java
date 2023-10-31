package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(CartPageAE.class.getName());

    public CartPageAE(WebDriver driver) {
        super(driver);
    }

    //objects (web elements)
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//div[@class='modal-body']/p/a[@href='/login']")
    WebElement loginBtnOnModal;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement productRemoveBtn;

    //reusable steps
    public String verifyCartPageIsDisplayed(){
        String cartPageTitle = getCurrentTitle();
        LOG.info("cart page title visible: "+cartPageTitle);
        return cartPageTitle;
    }

    public void clickOnProceedToCheckoutBtn(){
        clickOn(proceedToCheckoutBtn);
        LOG.info("click on proceed to checkout success");
    }

    public void clickOnModalsLoginBtn(){
        clickOn(loginBtnOnModal);
        LOG.info("click on login button from modal success");
    }

    public void clickOnProductRemoveBtn(){
        clickOn(productRemoveBtn);
        LOG.info("click on product remove button success");
    }

    public void verifyIsCartIsEmpty(){
        if (productRemoveBtn == null) {
            LOG.info("product is removed from the cart");
        } else {
            LOG.info("product is available in the cart");
        }
    }
}
