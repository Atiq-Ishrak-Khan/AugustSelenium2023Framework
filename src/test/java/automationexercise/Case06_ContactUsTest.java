package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.ContactUsPageAE;
import pages.automationpractice.com.HomePageAE;

import org.openqa.selenium.Alert;

public class Case06_ContactUsTest extends CommonAPI {

    @Test
    public void contactUsForm() {
        HomePageAE homePage = new HomePageAE(getDriver());
        ContactUsPageAE contactUs = new ContactUsPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // Verify that home page is visible successfully
        homePage.getSectionTitleText();

        // click on 'Contact Us' button
        homePage.clickOnContactUsLink();

        // verify 'GET IN TOUCH' is visible
        contactUs.getInTouchTitleText();

        // enter name, email, subject and message
        contactUs.typeName("test name");
        contactUs.typeEmail(getRandomMail());
        contactUs.typeSubject("test subject");
        contactUs.typeMessage("test message");

        // upload file
        String relativeFilePath = "/src/test/resources/test-image.jpg";
        String projectRoot = System.getProperty("user.dir");
        String absoluteFilePath = projectRoot + relativeFilePath;
        contactUs.uploadFile(absoluteFilePath);

        // click 'Submit' button
        contactUs.clickOnSubmitBtn();

        // click OK button
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // driver.switchTo().alert().accept();

        // verify success message 'Success! Your details have been submitted successfully.' is visible
        contactUs.successMessageAlertText();

        // click 'Home' button and verify that landed to home page successfully
        contactUs.clickOnHomeBtn();
        homePage.getSectionTitleText();
    }
}
