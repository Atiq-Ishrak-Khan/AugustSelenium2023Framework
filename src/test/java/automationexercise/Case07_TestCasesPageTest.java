package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;

public class Case07_TestCasesPageTest extends CommonAPI {

    @Test
    public void verifyTestCasesPage(){
        HomePageAE homePage = new HomePageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click on 'Test Cases' button
        homePage.clickOnTestCasesBtn();

        // verify user is navigated to test cases page successfully
        homePage.testCaseTitleText();
    }

}
