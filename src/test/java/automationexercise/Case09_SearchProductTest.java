package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case09_SearchProductTest extends CommonAPI {

    @Test
    public void searchProduct(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click on 'Products' button
        productPage.clickOnProductsLink();

        // verify user is navigated to ALL PRODUCTS page successfully
        productPage.allProductsTitleText();

        // enter product name in search input and click search button
        productPage.typeInSearchField("Women");
        productPage.clickOnSearchBtn();

        // verify 'SEARCHED PRODUCTS' is visible
        productPage.verifySearchedProducts();

        // verify all the products related to search are visible
        productPage.verifySearchedProductsTitle();
    }
}
