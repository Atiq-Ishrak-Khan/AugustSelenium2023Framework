package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;
import pages.nopcommerce.ProductPageAE;
import pages.nopcommerce.CartPageAE;

public class test15_RemoveProductsFromCart extends CommonAPI {

    @Test
    public void verifyRemoveProductsFromCart() {
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page is visible successfully
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
            throw new RuntimeException(e);
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

        // Click 'X' button corresponding to a particular product
        cartPage.clickOnProductRemoveBtn();

        // Verify that the product is removed from the cart
        cartPage.verifyIsCartEmpty();
    }
}
