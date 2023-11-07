package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;
import pages.nopcommerce.SignupPageAE;

public class test5_InvalidSignup extends CommonAPI {
    String firstName = "John"; // Provide the first name
    String lastName = "Doe"; // Provide the last name
    String username = firstName + " " + lastName;
    String email = "adelsoumbati@gmail.com"; // Provide an existing email

    @Test
    public void registerUserWithExistingEmail() {
        HomePageAE homePage = new HomePageAE(getDriver());
        SignupPageAE signupPage = new SignupPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click on the Signup - Login link to navigate to the registration page
        homePage.clickOnSignupLoginLink();

        // Verify that the registration page is displayed (New User Signup! is visible)
        String newUserSignupText = signupPage.newUserSignupText();
        assert newUserSignupText.contains("New User Signup!");

        // Enter a name and an already registered email address
        signupPage.typeUsername(username);
        signupPage.typeUserEmail(email);

        // Click the Signup button
        signupPage.clickOnSignupBtn();

        // Verify that the error 'Email Address already exists!' is visible
        String signupFailedAlertText = homePage.signupFailedAlertText();
        assert signupFailedAlertText.contains("Email Address already exists!");

        // Optionally, you can perform additional verifications or actions here
    }
}
