package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.SignupPageAE;

public class Case05_InvalidSignupTest extends CommonAPI {
    String fname = prop.getProperty("user_fname");
    String lname = prop.getProperty("user_lname");
    String username = fname +" "+ lname;
    String email = prop.getProperty("user_email_not_for_delete");

    @Test
    public void registerUserWithExistingEmail() {
        HomePageAE homePage = new HomePageAE(getDriver());
        SignupPageAE signupPage = new SignupPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // Verify that home page is visible successfully
        homePage.getSectionTitleText();

        // Click the signup - login link
        homePage.clickOnSignupLoginLink();

        //  Verify 'New User Signup!' is visible
        signupPage.newUserSignupText();

        // enter name and already registered email address
        signupPage.typeUsername(username);
        signupPage.typeUserEmail(email);

        // click 'Signup' button
        signupPage.clickOnSignupBtn();

        // verify error 'Email Address already exist!' is visible
        homePage.signupFailedAlertText();
    }
}
