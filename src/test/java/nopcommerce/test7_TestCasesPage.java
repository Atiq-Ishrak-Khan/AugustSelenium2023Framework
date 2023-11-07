package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;

public class test7_TestCasesPage extends CommonAPI {

    @Test
    public void verifyTestCasesPage() {
        HomePageAE homePage = new HomePageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click on the 'Test Cases' button
        homePage.clickOnTestCasesBtn();

        // Verify that the 'Test Cases' page title is visible
        String testCaseTitle = homePage.testCaseTitleText();
        assert testCaseTitle.contains("Test Cases");

        // Optionally, you can perform additional verifications or actions on the Test Cases page
    }
}
