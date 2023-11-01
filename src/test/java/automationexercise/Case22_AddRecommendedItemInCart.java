package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.CartPageAE;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case22_AddRecommendedItemInCart extends CommonAPI {

    @Test
    public void verifyAddToCartFromRecommendedItems(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());
        CartPageAE cartPage = new CartPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // scroll to bottom of page
        homePage.scrollToRecommendedItemsSection();

        // verify 'RECOMMENDED ITEMS' are visible
        homePage.getRecommendedItemsTitleText();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // click on 'Add To Cart' on Recommended product
        homePage.clickOnARecommendedItemBtn();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // click on 'View Cart' button
        productPage.continueShoppingModalBtb();
        homePage.clickOnCartLink();

        // verify that product is displayed in cart page
        cartPage.verifyCartPageIsDisplayed();
    }
}
