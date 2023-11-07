package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;
import pages.nopcommerce.ProductPageAE;
import pages.nopcommerce.CartPageAE;

public class test11_ProductQuantityCart extends CommonAPI {

    @Test
    public void verifyProductQuantityInCart() {
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click 'View Product' for any product on the home page
        productPage.clickOnFirstProductsLink();

        // Verify that the product detail page is opened
        String productDetailTitle = productPage.verifyProductDetailTitle();
        assert productDetailTitle.contains("Product Details");

        // Increase the product quantity to 4
        productPage.typeProductQuantity(4);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        // Click 'Add to Cart' button
        productPage.clickOnAddToCartBtn();
        productPage.continueShoppingModalBtn();

        // Click 'View Cart' button
        homePage.clickOnCartLink();

        // Verify that the product is displayed in the cart page with the exact quantity
        cartPage.verifyProductQuantity(4);

        // Optionally, you can perform additional verifications or actions here
    }
}
