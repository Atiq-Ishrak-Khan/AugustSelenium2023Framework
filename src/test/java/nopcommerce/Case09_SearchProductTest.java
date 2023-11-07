package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.ProductPageAE;

public class Case09_SearchProductTest extends CommonAPI {

    @Test
    public void searchProduct() {
        HomePageAE homePage = new HomePageAE(getDriver());
        ProductPageAE productPage = new ProductPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click on the 'Products' link to navigate to the ALL PRODUCTS page
        productPage.clickOnProductsLink();

        // Verify that the 'ALL PRODUCTS' page title is visible
        String allProductsTitle = productPage.allProductsTitleText();
        assert allProductsTitle.contains("ALL PRODUCTS");

        // Enter a product name in the search input and click the search button
        productPage.typeInSearchField("Women");
        productPage.clickOnSearchBtn();

        // Verify that the 'SEARCHED PRODUCTS' title is visible
        String searchedProductsTitle = productPage.verifySearchedProductsTitle();
        assert searchedProductsTitle.contains("SEARCHED PRODUCTS");

        // Verify that all the products related to the search are visible
        if (!productPage.verifySearchedProducts()) throw new AssertionError();

        // Optionally, you can perform additional verifications or actions on the searched products
    }
}
