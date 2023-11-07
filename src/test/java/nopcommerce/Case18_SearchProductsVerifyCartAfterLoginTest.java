package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.ProductPageAE;
import pages.LoginPageAE;

public class Case18_SearchProductsVerifyCartAfterLoginTest extends CommonAPI {
    String email = prop.getProperty("user_email_not_for_delete");
    String password = prop.getProperty("user_pass");

    @Test
    public void verifyCaseSearchProductsAndVerifyCartAfterLogin(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        LoginPageAE loginPage = new LoginPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Close adblock browser tab and reload the main tab
        closeAllTabsExceptFirstTab();

        // Click on the 'Products' button
        productPage.clickOnProductsLink();

        // Verify user is navigated to the ALL PRODUCTS page successfully
        productPage.allProductsTitleText();

        // Enter a product name in the search input and click the search button
        productPage.typeInSearchField("pink");
        productPage.clickOnSearchBtn();

        // Verify 'SEARCHED PRODUCTS' is visible
        productPage.verifySearchedProducts();

        // Verify all the products related to the search are visible
        productPage.verifySearchedProductsTitle();

        // Add those products to the cart
        productPage.addAllVisibleProductToCart();

        // Click 'Cart' button and verify that products are visible in the cart
        homePage.clickOnCartLink();

        // Click 'Signup / Login' button and submit login details
        homePage.clickOnSignupLoginLink();

        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickOnLoginBtn();

        // Again, go to the Cart page
        homePage.clickOnCartLink();

        // Verify that those products are visible in the cart after login as well
        productPage.verifyPriceQuantity();
    }
}
