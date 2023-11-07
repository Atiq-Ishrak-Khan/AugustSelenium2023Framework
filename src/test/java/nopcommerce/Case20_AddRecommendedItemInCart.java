package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.CartPageAE;
import pages.HomePageAE;
import pages.ProductPageAE;

public class Case20_AddRecommendedItemInCart extends CommonAPI {

    @Test
    public void verifyAddToCartFromRecommendedItems(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());

        // Scroll to the bottom of the page
        homePage.scrollToRecommendedItemsSection();

        // Verify 'RECOMMENDED ITEMS' are visible
        homePage.getRecommendedItemsTitleText();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click on 'Add To Cart' on Recommended product
        homePage.clickOnARecommendedItemBtn();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click on 'View Cart' button
        productPage.continueShoppingModalBtb();
        homePage.clickOnCartLink();

        // Verify that the product is displayed in the cart page
        cartPage.verifyCartPageIsDisplayed();
    }
}
