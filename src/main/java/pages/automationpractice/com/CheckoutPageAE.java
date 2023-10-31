package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(CheckoutPageAE.class.getName());

    public CheckoutPageAE(WebDriver driver) {
        super(driver);
    }

    //objects (web elements)
    @FindBy(id = "address_delivery")
    List<WebElement> addressesElement;

    @FindBy(name = "message")
    WebElement descriptionTextarea;

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderBtn;

    @FindBy(name = "name_on_card")
    WebElement nameOnCardField;

    @FindBy(name = "card_number")
    WebElement cardNumberField;

    @FindBy(name = "cvc")
    WebElement cvcField;

    @FindBy(name = "expiry_month")
    WebElement expiryMonthField;

    @FindBy(name = "expiry_year")
    WebElement expiryYearField;

    @FindBy(id = "submit")
    WebElement payAndConfirmOrderBtn;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//section[@id='form']//p")
    WebElement successMessageAlertElement;

    @FindBy(xpath = "//div[@id='dismiss-button']")
    WebElement adDismissButton;

    //reusable steps
    public void getAddressDetails(){
        for (WebElement addressItem : addressesElement) {
            String text = addressItem.getText();
            LOG.info("address line: "+ text);
        }
    }

    public void typeDescriptionInTextarea(String description){
        type(descriptionTextarea, description);
        LOG.info("type description in checkout page success");
    }

    public void clickOnPlaceOrderBtn(){
        clickOn(placeOrderBtn);
        LOG.info("click on place order button success");
    }

    public void typeNameOnCard(String name){
        type(nameOnCardField, name);
        LOG.info("type name in card checkout page success");
    }

    public void typeCardNumber(String cardNumber){
        type(cardNumberField, cardNumber);
        LOG.info("type card number in card checkout page success");
    }

    public void typeCVC(String cvc){
        type(cvcField, cvc);
        LOG.info("type cvc number in card checkout page success");
    }

    public void typeExpiryMonth(String expiryMonth){
        type(expiryMonthField, expiryMonth);
        LOG.info("type expiry month in card checkout page success");
    }

    public void typeExpiryYear(String expiryYear){
        type(expiryYearField, expiryYear);
        LOG.info("type expiry year in card checkout page success");
    }

    public void clickOnPayAndConfirmOrderBtn(){
        clickOn(payAndConfirmOrderBtn);
        LOG.info("click on pay and confirm button in card checkout page success");
    }

    public void clickOnContinueBtn(){
        clickOn(continueBtn);
        LOG.info("click on continue button in card checkout page success");
    }

    public String verifyOrderPlacedSuccessAlert(){
        String successMessage = getElementText(successMessageAlertElement);
        LOG.info("order placed text visible: "+successMessage);
        return successMessage;
    }
}
