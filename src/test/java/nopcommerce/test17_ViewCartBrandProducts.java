package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;
import pages.nopcommerce.BrandPageAE;
import pages.nopcommerce.ProductPageAE;

public class test17_ViewCartBrandProducts extends CommonAPI {

    @Test
    public void verifyViewAndCartBrandProducts() {
        ProductPageAE productPage = new ProductPageAE(getDriver());
        BrandPageAE brandPage = new BrandPageAE(getDriver());
        HomePageAE homePage = new HomePageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Click on the 'Products' button
        productPage.clickOnProductsLink();

        // Verify that Brands are visible on the left sidebar
        brandPage.brandSidebarTextTitle();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click on any brand name, for example, 'Polo'
        brandPage.clickOnPoloBrand();

        // Verify that the user is navigated to the brand page and brand products are displayed
        brandPage.verifyBrandPage();
        productPage.verifyAllProductsList();

        // On the left sidebar, click on any other brand link, for example, 'Baby Hug'
        brandPage.clickOnBabyHugBrand();

        // Verify that the user is navigated to that brand page and can see products
        brandPage.verifyBrandPage();
        productPage.verifyAllProductsList();

        // Optionally, you can add products to the cart and perform further verifications or actions
    }
}
