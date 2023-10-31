package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case13_ProductQuantityCartTest extends CommonAPI {

    @Test
    public void verifyProductQuantityInCart(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click 'View Product' for any product on home page
        productPage.clickOnFirstProductsLink();

        // verify product detail is opened
        productPage.verifyProductDetailTitle();

        // increase quantity to 4
        productPage.typeProductQuantity(4);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        // click 'Add to cart' button
        productPage.clickOnAddToCartBtn();
        productPage.continueShoppingModalBtb();

        // click 'View Cart' button
        homePage.clickOnCartLink();

        // verify that product is displayed in cart page with exact quantity
        productPage.verifyPriceQuantity();
    }
}
