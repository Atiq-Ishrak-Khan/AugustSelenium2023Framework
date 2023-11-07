package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;

public class test21_ScrollUpDownUsingArrowBtnTest extends CommonAPI {

    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality(){
        HomePageAE homePage = new HomePageAE(getDriver());

        // Verify that home page is visible successfully
        homePage.getSectionTitleText();

        // Scroll down page to the bottom
        homePage.scrollToDown();

        // Verify 'SUBSCRIPTION' is visible
        homePage.subscriptionLabelText();

        // Click on the arrow at the bottom right side to move upward
        homePage.clickOnScrollUpBtn();

        // Verify that the page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on the screen
        homePage.verifyMainCarouselContentText();
    }
}
