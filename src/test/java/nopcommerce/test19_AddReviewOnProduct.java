package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.ProductPageAE;

public class test19_AddReviewOnProduct extends CommonAPI {
    String fname = prop.getProperty("user_fname");
    String lname = prop.getProperty("user_lname");
    String username = fname + " " + lname;
    String reviewComment = prop.getProperty("review_comment");

    @Test
    public void verifyAddReviewOnProduct() {
        ProductPageAE productPage = new ProductPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Close adblock browser tab and reload the main tab
        closeAllTabsExceptFirstTab();

        // Click on the 'Products' button
        productPage.clickOnProductsLink();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify user is navigated to the ALL PRODUCTS page successfully
        productPage.verifyAllProductsList();

        // Click on 'View Product' button
        productPage.clickOnFirstProductsLink();

        // Verify 'Write Your Review' is visible
        productPage.verifyReviewTitleText();

        // Enter name, email and review
        productPage.typeNameOnReviewForm(username);
        productPage.typeEmailOnReviewForm(getRandomMail());
        productPage.typeCommentOnReviewForm(reviewComment);

        // Click 'Submit' button
        productPage.clickOnReviewSubmitBtn();

        // Verify success message 'Thank you for your review.'
        productPage.verifyReviewSuccessAlert();
    }
}
