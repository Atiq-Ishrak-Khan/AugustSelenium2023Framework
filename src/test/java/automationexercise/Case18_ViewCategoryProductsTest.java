package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.CategoryPageAE;

public class Case18_ViewCategoryProductsTest extends CommonAPI {

    @Test
    public void verifyViewCategoryProducts(){
        CategoryPageAE categoryPage = new CategoryPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that categories are visible on left sidebar
        categoryPage.categorySidebarTextTitle();

        // click on 'Women' category
        categoryPage.clickOnWomenCategory();

        // click on any category link under 'Women' category, for example: Dress
        categoryPage.clickOnWomenDress();

        // verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'
        categoryPage.verifyFeaturesItemsTitle();

        // on left sidebar, click on any sub-category link of 'Men' category
        categoryPage.clickOnMenCategory();
        categoryPage.clickOnMenTshirts();
    }
}
