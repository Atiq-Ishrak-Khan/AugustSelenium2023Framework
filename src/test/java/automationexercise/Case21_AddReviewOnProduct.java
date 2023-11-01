package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.ProductPageAE;

public class Case21_AddReviewOnProduct extends CommonAPI {
    String fname = prop.getProperty("user_fname");
    String lname = prop.getProperty("user_lname");
    String username = fname +" "+ lname;
    // String email = prop.getProperty("user_email");
    String reviewComment = prop.getProperty("review_comment");

    @Test
    public void verifyAddReviewOnProduct(){
        ProductPageAE productPage = new ProductPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // click on 'Products' button
        productPage.clickOnProductsLink();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // verify user is navigated to ALL PRODUCTS page successfully
        productPage.verifyAllProductsList();

        // click on 'View Product' button
        productPage.clickOnFirstProductsLink();

        // verify 'Write Your Review' is visible
        productPage.verifyReviewTitleText();

        // enter name, email and review
        productPage.typeNameOnReviewForm(username);
        productPage.typeEmailOnReviewForm(getRandomMail());
        productPage.typeCommentOnReviewForm(reviewComment);

        // click 'Submit' button
        productPage.clickOnReviewSubmitBtn();

        // verify success message 'Thank you for your review.'
        productPage.verifyReviewSuccessAlert();
    }
}
