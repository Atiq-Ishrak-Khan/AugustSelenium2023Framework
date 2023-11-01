package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;

public class Case26_ScrollUpWithoutArrowBtnAndScrollDown extends CommonAPI {

    @Test
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality(){
        HomePageAE homePage = new HomePageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // scroll down page to bottom
        homePage.scrollToDown();

        // verify 'SUBSCRIPTION' is visible
        homePage.subscriptionLabelText();

        // scroll up page to top
        homePage.scrollToUp();

        // verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        homePage.verifyMainCarouselContentText();
    }
}
