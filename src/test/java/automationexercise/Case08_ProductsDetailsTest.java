package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case08_ProductsDetailsTest extends CommonAPI {

    @Test
    public void verifyAllProductsAndProductDetailPage(){
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // Verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click on 'Products' button
        productPage.clickOnProductsLink();

        // verify user is navigated to ALL PRODUCTS page successfully
        productPage.allProductsTitleText();

        // the products list is visible
        productPage.verifyAllProductsList();

        // click on View Product of first product
        productPage.clickOnFirstProductsLink();

        // user is landed to product detail page
        productPage.verifyProductDetailTitle();

        // verify that detail is visible: product name, category, price, availability, condition, brand
        productPage.getProductName();
        productPage.getProductCategory();
        productPage.getProductPrice();
        productPage.getProductAvailability();
        productPage.getProductCondition();
        productPage.getProductBrand();
    }
}
