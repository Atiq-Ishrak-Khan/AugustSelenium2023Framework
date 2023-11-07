package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.nopcommerce.HomePageAE;
import pages.nopcommerce.LoginPageAE;

public class test4_LogoutUser extends CommonAPI {
    String email = "your_valid_email@example.com"; // Provide a valid email
    String password = "your_valid_password"; // Provide a valid password

    @Test
    public void logoutUser() {
        HomePageAE homePage = new HomePageAE(getDriver());
        LoginPageAE loginPage = new LoginPageAE(getDriver());

        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click on the Login link to navigate to the login page
        homePage.clickOnLoginLink();

        // Verify that the login page is displayed
        String loginText = loginPage.loginTextTitle();
        assert loginText.contains("Welcome, Please Sign In!");

        // Enter a valid email address and password to log in
        loginPage.typeEmail(email);
        loginPage.typePassword(password);

        // Click the Login button
        loginPage.clickOnLoginBtn();

        // Verify that the user is successfully logged in (Logged in as username is visible)
        String loggedInUserName = homePage.getLoggedUserName();
        assert loggedInUserName.contains("Welcome, " + email);

        // Click the Logout link
        homePage.clickOnLogoutLink();

        // Verify that the user is navigated to the login page (login to your account is visible)
        String loginTextAfterLogout = loginPage.loginTextTitle();
        assert loginTextAfterLogout.contains("Welcome, Please Sign In!");

        // Optionally, you can perform additional verifications or actions here
    }
}
