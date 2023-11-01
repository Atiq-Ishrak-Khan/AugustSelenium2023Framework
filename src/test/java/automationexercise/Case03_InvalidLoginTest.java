package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.LoginPageAE;

public class Case03_InvalidLoginTest extends CommonAPI {
    String incorrectEmail = prop.getProperty("incorrect_email");
    String incorrectPass = prop.getProperty("incorrect_pass");

    @Test
    public void loginWithValidCredentials() {
        HomePageAE homePage = new HomePageAE(getDriver());
        LoginPageAE loginPage = new LoginPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // Verify that home page is visible successfully
        homePage.getSectionTitleText();

        // Click the signup - login button
        homePage.clickOnSignupLoginLink();

        // verify login to your account is visible
        loginPage.loginTextTitle();

        // enter incorrect email address and password
        loginPage.typeEmail(incorrectEmail);
        loginPage.typePassword(incorrectPass);

        // click 'login' button
        loginPage.clickOnLoginBtn();

        // verify error 'Your email or password is incorrect!' is visible
        homePage.incorrectLoginAlertText();
    }
}
