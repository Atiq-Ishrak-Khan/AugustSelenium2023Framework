package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.ProductPageAE;
import pages.CartPageAE;

public class Case10_AddProductCart extends CommonAPI {

    @Test
    public void verifyAddProductsInCart() {
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click 'Products' button
        productPage.clickOnProductsLink();

        // Add the first product to the cart
        productPage.hoverOverFirstProduct();
        productPage.addToCartFirstProduct();
        productPage.continueShoppingModalBtn();

        // Add the second product to the cart
        productPage.hoverOverSecondProduct();
        productPage.addToCartSecondProduct();
        productPage.continueShoppingModalBtn();

        // Click 'View Cart' button
        homePage.clickOnCartLink();

        // Verify both products are added to the Cart
        cartPage.verifyCartProducts();

        // Verify their prices, quantity, and total price
        cartPage.verifyPriceQuantity();


    }
}
