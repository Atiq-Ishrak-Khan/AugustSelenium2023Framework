package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;

public class Case10_SubscriptionTest extends CommonAPI {

    @Test
    public void verifySubscriptionInHomePage(){
        HomePageAE homePage = new HomePageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // scroll down to footer
        homePage.scrollToDown();

        // verify text 'SUBSCRIPTION'
        homePage.subscriptionLabelText();

        // enter email address in input and click arrow button
        homePage.typeSubscriptionEmail(getRandomMail());
        homePage.clickOnSubscriptionArrowBtn();

        // verify success message 'You have been successfully subscribed!' is visible
        homePage.verifySubscriptionSuccessAlert();
    }
}
