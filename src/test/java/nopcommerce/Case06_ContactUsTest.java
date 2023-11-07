package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.ContactUsPageAE;

import org.openqa.selenium.Alert;

public class Case06_ContactUsTest extends CommonAPI {

    @Test
    public void contactUsForm() {
        HomePageAE homePage = new HomePageAE(getDriver());
        ContactUsPageAE contactUs = new ContactUsPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click on the 'Contact Us' link to navigate to the Contact Us page
        homePage.clickOnContactUsLink();

        // Verify that the 'GET IN TOUCH' title is visible
        String getInTouchTitle = contactUs.getInTouchTitleText();
        assert getInTouchTitle.contains("GET IN TOUCH");

        // Enter name, email, subject, and message in the Contact Us form
        contactUs.typeName("John Doe");
        contactUs.typeEmail(getRandomMail());
        contactUs.typeSubject("Test Subject");
        contactUs.typeMessage("This is a test message");

        // Upload a file
        String relativeFilePath = "/src/test/resources/test-image.jpg";
        String projectRoot = System.getProperty("user.dir");
        String absoluteFilePath = projectRoot + relativeFilePath;
        contactUs.uploadFile(absoluteFilePath);

        // Click the 'Submit' button
        contactUs.clickOnSubmitBtn();

        // Handle the alert and accept it
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

        // Verify the success message 'Success! Your details have been submitted successfully.' is visible
        String successMessage = contactUs.successMessageAlertText();
        assert successMessage.contains("Success! Your details have been submitted successfully.");

        // Click the 'Home' button and verify that it lands on the home page successfully
        contactUs.clickOnHomeBtn();
        sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Optionally, you can perform additional verifications or actions here
    }
}
