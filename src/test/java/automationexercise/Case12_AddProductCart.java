package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case12_AddProductCart extends CommonAPI {

    @Test
    public void verifyAddProductsInCart(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click 'Products' button
        productPage.clickOnProductsLink();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        // hover over first product and click 'Add to cart'
        productPage.hoverOverFirstProduct();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        productPage.addToCartFirstProduct();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        // click 'Continue Shopping' button
        productPage.continueShoppingModalBtb();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        // hover over second product and click 'Add to cart'
        productPage.hoverOverFirstProduct();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        productPage.addToCartFirstProduct();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        // click 'View Cart' button
        productPage.continueShoppingModalBtb();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        homePage.clickOnCartLink();

        // verify both products are added to Cart
        productPage.verifyCartProducts();

        // verify their prices, quantity and total price
        productPage.verifyPriceQuantity();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

    }
}
