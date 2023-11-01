package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.*;

public class Case16_PlaceOrderLoginBeforeCheckoutTest extends CommonAPI {
    String email = prop.getProperty("user_email_not_for_delete");
    String password = prop.getProperty("user_pass");

    @Test
    public void verifyPlaceOrderLoginBeforeCheckout(){
        HomePageAE homePage = new HomePageAE(getDriver());
        LoginPageAE loginPage = new LoginPageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());
        CheckoutPageAE checkoutPage = new CheckoutPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click 'Signup / Login' button
        homePage.clickOnSignupLoginLink();

        // fill email, password and click 'Login' button
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickOnLoginBtn();

        // verify 'Logged in as username' at top
        homePage.loggedUserNameText();

        // add products to cart
        productPage.hoverOverFirstProduct();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        productPage.addToCartFirstProduct();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        productPage.continueShoppingModalBtb();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // click 'Cart' button
        homePage.clickOnCartLink();

        // verify that cart page is displayed
        cartPage.verifyCartPageIsDisplayed();

        // click Proceed To Checkout
        cartPage.clickOnProceedToCheckoutBtn();

        // verify Address Details and Review Your Order
        checkoutPage.getAddressDetails();

        // enter description in comment text area and click 'Place Order'
        checkoutPage.typeDescriptionInTextarea("this is a demo description");
        checkoutPage.clickOnPlaceOrderBtn();

        // enter payment details: Name on Card, Card Number, CVC, Expiration date
        checkoutPage.typeNameOnCard("test name");
        checkoutPage.typeCardNumber("0000111122223333");
        checkoutPage.typeCVC("123");
        checkoutPage.typeExpiryMonth("12");
        checkoutPage.typeExpiryYear("2010");

        // click 'Pay and Confirm Order' button
        checkoutPage.clickOnPayAndConfirmOrderBtn();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // verify success message 'Your order has been placed successfully!'
        checkoutPage.verifyOrderPlacedSuccessAlert();
        checkoutPage.clickOnContinueBtn();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // click 'Delete Account' button
        // homePage.clickOnAccountDeleteBtn();

        // verify 'ACCOUNT DELETED!' and click 'Continue' button
        // homePage.accountDeletedText();
    }
}
