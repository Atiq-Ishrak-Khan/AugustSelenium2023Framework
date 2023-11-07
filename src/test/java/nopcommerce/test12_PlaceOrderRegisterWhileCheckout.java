package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;
import pages.nopcommerce.ProductPageAE;
import pages.nopcommerce.CartPageAE;
import pages.nopcommerce.SignupPageAE;
import pages.nopcommerce.CheckoutPageAE;

class Case12_PlaceOrderRegisterWhileCheckoutTest extends CommonAPI {

    private Exception a;

    @Test
    public void verifyPlaceOrderRegisterWhileCheckout() throws Exception {
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());
        SignupPageAE signupPage = new SignupPageAE(getDriver());
        CheckoutPageAE checkoutPage = new CheckoutPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

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
            throw a;
        }

        productPage.continueShoppingModalBtn();

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

        // Click 'Register / Login' button
        cartPage.clickOnModalsLoginBtn();

        // Fill all details in Signup and create an account
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

        // Verify 'ACCOUNT CREATED!' and click 'Continue' button
        signupPage.clickOnCreateAccountBtn();
        signupPage.clickOnContinueBtn();

        // Verify 'Logged in as username' at the top
        homePage.loggedUserNameText();

        // Click 'Cart' button
        homePage.clickOnCartLink();

        // Click 'Proceed To Checkout' button
        cartPage.clickOnProceedToCheckoutBtn();

        // Verify Address Details and Review Your Order
        checkoutPage.getAddressDetails();

        // Enter a description in the comment text area and click 'Place Order'
        checkoutPage.typeDescriptionInTextarea("This is a demo description");
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

        // Click 'Delete Account' button
        homePage.clickOnAccountDeleteBtn();

        // Verify 'ACCOUNT DELETED!' and click 'Continue' button
        homePage.accountDeletedText();
        homePage.clickOnContinueBtn();
    }
}
