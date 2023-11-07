package pages.nopcommerce;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(CheckoutPageAE.class.getName());

    public CheckoutPageAE(WebDriver driver) {
        super(driver);
    }

    // Web Elements (Page Objects)
    @FindBy(id = "shipping-address-select")
    private List<WebElement> shippingAddresses;

    @FindBy(id = "delivery-method-select")
    private List<WebElement> deliveryMethods;

    @FindBy(id = "billing-address-select")
    private List<WebElement> billingAddresses;

    @FindBy(id = "payment-method-select")
    private List<WebElement> paymentMethods;

    @FindBy(id = "CardName")
    private WebElement nameOnCardField;

    @FindBy(id = "CardNumber")
    private WebElement cardNumberField;

    @FindBy(id = "ExpireMonth")
    private WebElement expiryMonthField;

    @FindBy(id = "ExpireYear")
    private WebElement expiryYearField;

    @FindBy(id = "CardCode")
    private WebElement cvcField;

    @FindBy(id = "confirm-order")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@class='message-success']")
    private WebElement successMessageElement;

    // Reusable methods
    public void selectShippingAddress(int index) {
        if (index >= 0 && index < shippingAddresses.size()) {
            clickOn(shippingAddresses.get(index));
            LOG.info("Selected shipping address with index: " + index);
        } else {
            LOG.error("Invalid index for shipping address selection");
        }
    }

    public void selectDeliveryMethod(int index) {
        if (index >= 0 && index < deliveryMethods.size()) {
            clickOn(deliveryMethods.get(index));
            LOG.info("Selected delivery method with index: " + index);
        } else {
            LOG.error("Invalid index for delivery method selection");
        }
    }

    public void selectBillingAddress(int index) {
        if (index >= 0 && index < billingAddresses.size()) {
            clickOn(billingAddresses.get(index));
            LOG.info("Selected billing address with index: " + index);
        } else {
            LOG.error("Invalid index for billing address selection");
        }
    }

    public void selectPaymentMethod(int index) {
        if (index >= 0 && index < paymentMethods.size()) {
            clickOn(paymentMethods.get(index));
            LOG.info("Selected payment method with index: " + index);
        } else {
            LOG.error("Invalid index for payment method selection");
        }
    }

    public void enterNameOnCard(String name) {
        type(nameOnCardField, name);
        LOG.info("Entered name on card: " + name);
    }

    public void enterCardNumber(String cardNumber) {
        type(cardNumberField, cardNumber);
        LOG.info("Entered card number: " + cardNumber);
    }

    public void enterExpiryMonth(String month) {
        type(expiryMonthField, month);
        LOG.info("Entered expiry month: " + month);
    }

    public void enterExpiryYear(String year) {
        type(expiryYearField, year);
        LOG.info("Entered expiry year: " + year);
    }

    public void enterCVC(String cvc) {
        type(cvcField, cvc);
        LOG.info("Entered CVC: " + cvc);
    }

    public void clickConfirmOrder() {
        clickOn(confirmOrderButton);
        LOG.info("Clicked on Confirm Order button");
    }

    public String getSuccessMessage() {
        String successMessage = getElementText(successMessageElement);
        LOG.info("Success message visible: " + successMessage);
        return successMessage;
    }
}
