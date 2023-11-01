package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.CartPageAE;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case17_RemoveProductsFromCartTest extends CommonAPI {

    @Test
    public void verifyRemoveProductsFromCart(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());

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

        // click 'X' button corresponding to particular product
        cartPage.clickOnProductRemoveBtn();

        // verify that product is removed from the cart
        cartPage.verifyIsCartIsEmpty();
    }
}
