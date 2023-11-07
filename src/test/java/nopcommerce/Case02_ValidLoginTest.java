package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.LoginPageAE;

public class Case02_ValidLoginTest extends CommonAPI {
    String email = "adelsoumbati.com"; // Provide a valid email
    String password = "33Holako"; // Provide a valid password

    @Test
    public void loginWithValidCredentials() {
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

        // Enter a valid email address and password
        loginPage.typeEmail(email);
        loginPage.typePassword(password);

        // Click the Login button
        loginPage.clickOnLoginBtn();

        // Verify that the user is successfully logged in
        String loggedUserName = homePage.getLoggedUserName();
        assert loggedUserName.contains("valid_username"); // Replace with the expected username

        // Optionally, you can perform additional verifications or actions here
    }
}
