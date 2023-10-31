package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.LoginPageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case20_SearchProductsVerifyCartAfterLoginTest extends CommonAPI {
    String email = prop.getProperty("user_email_not_for_delete");
    String password = prop.getProperty("user_pass");

    @Test
    public void verifyCaseSearchProductsAndVerifyCartAfterLogin(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        LoginPageAE loginPage = new LoginPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // click on 'Products' button
        productPage.clickOnProductsLink();

        // verify user is navigated to ALL PRODUCTS page successfully
        productPage.allProductsTitleText();

        // enter product name in search input and click search button
        productPage.typeInSearchField("pink");
        productPage.clickOnSearchBtn();

        // verify 'SEARCHED PRODUCTS' is visible
        productPage.verifySearchedProducts();

        // verify all the products related to search are visible
        productPage.verifySearchedProductsTitle();

        // add those products to cart
        productPage.addAllVisibleProductToCart();

        // click 'Cart' button and verify that products are visible in cart
        homePage.clickOnCartLink();

        // click 'Signup / Login' button and submit login details
        homePage.clickOnSignupLoginLink();

        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.clickOnLoginBtn();

        // again, go to Cart page
        homePage.clickOnCartLink();

        // verify that those products are visible in cart after login as well
        productPage.verifyPriceQuantity();
    }
}
