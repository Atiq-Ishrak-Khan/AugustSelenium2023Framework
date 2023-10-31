package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.*;

public class Case23_AddressDetailsInCheckout extends CommonAPI {

    @Test
    public void verifyAddressDetailsInCheckoutPage(){
        HomePageAE homePage = new HomePageAE(getDriver());
        SignupPageAE signupPage = new SignupPageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());
        CheckoutPageAE checkoutPage = new CheckoutPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click 'Signup / Login' button
        homePage.clickOnSignupLoginLink();

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

        // verify that the delivery address is same address filled at the time registration of account
        checkoutPage.getAddressDetails();

        // verify that the billing address is same address filled at the time registration of account
        checkoutPage.getAddressDetails();

        // click 'Delete Account' button
        homePage.clickOnAccountDeleteBtn();

        // verify 'ACCOUNT DELETED!' and click 'Continue' button
        homePage.accountDeletedText();
    }
}
