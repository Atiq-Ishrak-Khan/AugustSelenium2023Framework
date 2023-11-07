package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.ProductPageAE;

public class Case08_ProductsDetailsTest extends CommonAPI {

    @Test
    public void verifyAllProductsAndProductDetailPage() {
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

        // Verify that the products list is visible
        if (!productPage.verifyAllProductsList()) throw new AssertionError();

        // Click on 'View Product' of the first product
        productPage.clickOnFirstProductsLink();

        // Verify that the user is landed on the product detail page
        String productDetailTitle = productPage.verifyProductDetailTitle();
        assert productDetailTitle.contains("Product Details");

        // Verify that product details are visible: name, category, price, availability, condition, brand
        String productName = productPage.getProductName();
        assert !productName.isEmpty();

        String productCategory = productPage.getProductCategory();
        assert !productCategory.isEmpty();

        String productPrice = productPage.getProductPrice();
        assert !productPrice.isEmpty();

        String productAvailability = productPage.getProductAvailability();
        assert !productAvailability.isEmpty();

        String productCondition = productPage.getProductCondition();
        assert !productCondition.isEmpty();

        String productBrand = productPage.getProductBrand();
        assert !productBrand.isEmpty();

        // Optionally, you can perform additional verifications or actions on the product detail page
    }
}
