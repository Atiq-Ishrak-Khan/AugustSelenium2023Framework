package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;
import pages.LoginPageAE;

public class Case03_InvalidLoginTest extends CommonAPI {
    String incorrectEmail = "kech@gmaol.com"; // Provide an invalid email
    String incorrectPass = "34Dsdg"; // Provide an invalid password

    @Test
    public void loginWithInvalidCredentials() {
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

        // Enter an incorrect email address and password
        loginPage.typeEmail(incorrectEmail);
        loginPage.typePassword(incorrectPass);

        // Click the Login button
        loginPage.clickOnLoginBtn();

        // Verify that an error message is displayed
        String errorMessage = loginPage.getErrorMessage();
        assert errorMessage.contains("Your email or password is incorrect!");

        // Optionally, you can perform additional verifications or actions here
    }
}
