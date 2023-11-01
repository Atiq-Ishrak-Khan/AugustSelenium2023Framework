package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.LoginPageAE;

public class Case04_LogoutUserTest extends CommonAPI {
    String email = prop.getProperty("user_email_not_for_delete");
    String password = prop.getProperty("user_pass");

    @Test
    public void logoutUser() {
        HomePageAE homePage = new HomePageAE(getDriver());
        LoginPageAE loginPage = new LoginPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // Verify that home page is visible successfully
        homePage.getSectionTitleText();

        // Click the signup - login link
        homePage.clickOnSignupLoginLink();

        // verify login to your account is visible
        loginPage.loginTextTitle();

        // enter correct email address and password
        loginPage.typeEmail(email);
        loginPage.typePassword(password);

        // click login button
        loginPage.clickOnLoginBtn();

        // verify that 'Logged in as username' is visible
        homePage.loggedUserNameText();

        // click 'Logout' button
        homePage.clickOnLogoutBtn();

        // verify that user is navigated to login page (login to your account is visible)
        loginPage.loginTextTitle();
    }
}
