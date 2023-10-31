package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.*;

public class Case14_PlaceOrderRegisterWhileCheckoutTest extends CommonAPI {

    @Test
    public void verifyPlaceOrderRegisterWhileCheckout(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());
        SignupPageAE signupPage = new SignupPageAE(getDriver());
        CheckoutPageAE checkoutPage = new CheckoutPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

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

        // click 'Register / Login' button
        cartPage.clickOnModalsLoginBtn();

        // fill all details in Signup and create account
        signupPage.newUserSignupText();

        signupPage.typeUsername("junior qa");
        signupPage.typeUserEmail(getRandomMail());
        signupPage.clickOnSignupBtn();

        signupPage.signupPageTitleText();

        signupPage.clickOnMrTitle();
        signupPage.typePassword("test@pass1");
        signupPage.selectDateOfBirth("15", "5", "1998");

        signupPage.clickOnNewsletter();
        signupPage.clickOnOffersCheckbox();

        signupPage.typeFirstName("qa");
        signupPage.typeLastName("tester");
        signupPage.typeCompanyName("none");
        signupPage.typePrimaryAddress("123 demo");
        signupPage.typeSecondaryAddress("none");
        signupPage.selectCountry("United States");
        signupPage.typeState("NY");
        signupPage.typeCity("New York");
        signupPage.typeZipCode("10007");
        signupPage.typeMobileNumber("000-000-0000");

        // verify 'ACCOUNT CREATED!' and click 'Continue' button
        signupPage.clickOnCreateAccountBtn();
        signupPage.clickOnContinueBtn();

        // verify ' Logged in as username' at top
        homePage.loggedUserNameText();

        // click 'Cart' button
        homePage.clickOnCartLink();

        // click 'Proceed To Checkout' button
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
        homePage.clickOnAccountDeleteBtn();

        // verify 'ACCOUNT DELETED!' and click 'Continue' button
        homePage.accountDeletedText();
        homePage.clickOnContinueBtn();
    }
}
