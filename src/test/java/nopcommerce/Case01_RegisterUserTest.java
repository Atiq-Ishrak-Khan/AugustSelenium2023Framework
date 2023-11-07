package nopcommerce;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePageAE;

public class Case01_RegisterUserTest extends CommonAPI {
    HomePageAE homePage = new HomePageAE(getDriver());

    @Test
    public void registerUser() {
        // Open the website
        getDriver().get("https://demo.nopcommerce.com/");

        // Verify that the home page section title is visible
        String sectionTitle = homePage.getSectionTitleText();
        assert sectionTitle.contains("Welcome to our store");

        // Click on the Login link to navigate to the login page
        homePage.clickOnLoginLink();

        // Verify that the login page is displayed
        String loginPageTitle = homePage.getTestCaseTitleText();
        assert loginPageTitle.equals("Welcome, Please Sign In!");

        // Fill in the registration details (you will need to provide these details)
        String firstName = "John";
        String lastName = "Doe";
        String email = "adelsoumebati@gmail.com";
        String password = "33Holako";

        // Perform user registration by calling methods on the page object
        homePage.generateReport(firstName, lastName, email, password);

        // Verify that the registration is successful by checking for a success message
        String successMessage = homePage.getSuccessMessage();
        assert successMessage.contains("Your registration completed");

        // Log out the user
        homePage.clickOnLogoutLink();

        // Verify that the user is logged out by checking the section title
        String sectionTitleAfterLogout = homePage.getSectionTitleText();
        assert sectionTitleAfterLogout.contains("Welcome to our store");
    }
}
