package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.BrandPageAE;
import pages.automationpractice.com.ProductPageAE;

public class Case19_ViewCartBrandProductsTest extends CommonAPI {

    @Test
    public void verifyViewAndCartBrandProducts(){
        ProductPageAE productPage = new ProductPageAE(getDriver());
        BrandPageAE brandPage = new BrandPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // click on 'Products' button
        productPage.clickOnProductsLink();

        // verify that Brands are visible on left sidebar
        brandPage.brandSidebarTextTitle();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // click on any brand name
        brandPage.clickOnPoloBrand();

        // verify that user is navigated to brand page and brand products are displayed
        brandPage.verifyBrandPage();
        productPage.verifyAllProductsList();

        // on left sidebar, click on any other brand link
        brandPage.clickOnBabyHugBrand();

        // verify that user is navigated to that brand page and can see products
        brandPage.verifyBrandPage();
        productPage.verifyAllProductsList();
    }
}
