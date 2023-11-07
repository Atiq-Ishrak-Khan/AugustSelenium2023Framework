package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;
import pages.nopcommerce.CategoryPageAE;

public class test16_ViewCategoryProducts extends CommonAPI {

    @Test
    public void verifyViewCategoryProducts() {
        HomePageAE homePage = new HomePageAE(getDriver());
        CategoryPageAE categoryPage = new CategoryPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page is visible successfully
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Close the Adblock browser tab and reload the main tab
        closeAllTabsExceptFirstTab();

        // Verify that categories are visible on the left sidebar
        categoryPage.categorySidebarTextTitle();

        // Click on the 'Women' category
        categoryPage.clickOnWomenCategory();

        // Click on any category link under 'Women' category, for example: Dress
        categoryPage.clickOnWomenDress();

        // Verify that the category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'
        categoryPage.verifyFeaturesItemsTitle();

        // On the left sidebar, click on any sub-category link of 'Men' category
        categoryPage.clickOnMenCategory();
        categoryPage.clickOnMenTshirts();
    }
}
