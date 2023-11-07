package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.LoginPageAE;
import pages.ProductPageAE;
import pages.CartPageAE;
import pages.CheckoutPageAE;

public class Case14_PlaceOrderLoginBeforeCheckoutTest extends CommonAPI {
    String email = prop.getProperty("user_email_not_for_delete");
    String password = prop.getProperty("user_pass");

    @Test
    public void verifyPlaceOrderLoginBeforeCheckout() {
        HomePageAE homePage = new HomePageAE(getDriver());
        LoginPageAE loginPage = new LoginPageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());
        CheckoutPageAE checkoutPage = new CheckoutPageAE(getDriver());

        // Close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // Verify that the home page is visible successfully
        homePage.getSectionTitleText();

        // Click 'Signup / Login' button
        homePage.clickOnSignupLoginLink();

        // Fill email, password and click 'Login' button
        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickOnLoginBtn();

        // Verify 'Logged in as username' at the top
        homePage.loggedUserNameText();

        // Add products to the cart
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

        // Click 'Cart' button
        homePage.clickOnCartLink();

        // Verify that the cart page is displayed
        cartPage.verifyCartPageIsDisplayed();

        // Click 'Proceed To Checkout'
        cartPage.clickOnProceedToCheckoutBtn();

        // Verify Address Details and Review Your Order
        checkoutPage.getAddressDetails();

        // Enter description in the comment text area and click 'Place Order'
        checkoutPage.typeDescriptionInTextarea("this is a demo description");
        checkoutPage.clickOnPlaceOrderBtn();

        // Enter payment details: Name on Card, Card Number, CVC, Expiration date
        checkoutPage.typeNameOnCard("test name");
        checkoutPage.typeCardNumber("0000111122223333");
        checkoutPage.typeCVC("123");
        checkoutPage.typeExpiryMonth("12");
        checkoutPage.typeExpiryYear("2010");

        // Click 'Pay and Confirm Order' button
        checkoutPage.clickOnPayAndConfirmOrderBtn();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify success message 'Your order has been placed successfully!'
        checkoutPage.verifyOrderPlacedSuccessAlert();
        checkoutPage.clickOnContinueBtn();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click 'Delete Account' button (if needed)
        // homePage.clickOnAccountDeleteBtn();

        // Verify 'ACCOUNT DELETED!' and click 'Continue' button (if needed)
        // homePage.accountDeletedText();
    }
}
