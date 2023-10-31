package automationexercise;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.automationpractice.com.HomePageAE;
import pages.automationpractice.com.SignupPageAE;

public class Case01_RegisterUserTest extends CommonAPI {
    String fname = prop.getProperty("user_fname");
    String lname = prop.getProperty("user_lname");
    String username = fname +" "+ lname;
    String password = prop.getProperty("user_pass");
    String company = prop.getProperty("user_company");
    String primaryAddress = prop.getProperty("user_primary_address");
    String secondaryAddress = prop.getProperty("user_secondary_address");
    String country = prop.getProperty("user_country");
    String state = prop.getProperty("user_state");
    String city = prop.getProperty("user_city");
    String zipcode = prop.getProperty("user_zipcode");
    String mobileNumber = prop.getProperty("user_mobile_number");
    String birthDate = prop.getProperty("user_birth_date");
    String birthMonth = prop.getProperty("user_birth_month");
    String birthYear = prop.getProperty("user_birth_year");

    @Test
    public void signupWithValidCredentials() {
        HomePageAE homePage = new HomePageAE(getDriver());
        SignupPageAE signupPage = new SignupPageAE(getDriver());

        // close adblock browser tab and reload main tab
        closeAllTabsExceptFirstTab();

        // verify that home page is visible successfully
        homePage.getSectionTitleText();

        // Click the signup - login link
        homePage.clickOnSignupLoginLink();

        //  Verify 'New User Signup!' is visible
        signupPage.newUserSignupText();

        // Enter name and email address
        signupPage.typeUsername(username);
        signupPage.typeUserEmail(getRandomMail());

        // Click 'Signup' button
        signupPage.clickOnSignupBtn();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        signupPage.signupPageTitleText();

        // Fill details: Title, Name, Email, Password, Date of birth
        signupPage.clickOnMrTitle();
        signupPage.typePassword(password);
        signupPage.selectDateOfBirth(birthDate, birthMonth, birthYear);

        // Select checkbox 'Sign up for our newsletter!'
        signupPage.clickOnNewsletter();

        // Select checkbox 'Receive special offers from our partners!'
        signupPage.clickOnOffersCheckbox();

        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        signupPage.typeFirstName(fname);
        signupPage.typeLastName(lname);
        signupPage.typeCompanyName(company);
        signupPage.typePrimaryAddress(primaryAddress);
        signupPage.typeSecondaryAddress(secondaryAddress);
        signupPage.selectCountry(country);
        signupPage.typeState(state);
        signupPage.typeCity(city);
        signupPage.typeZipCode(zipcode);
        signupPage.typeMobileNumber(mobileNumber);

        // click create account button
        signupPage.clickOnCreateAccountBtn();

        // verify that 'ACCOUNT CREATED!' is visible
        signupPage.accountCreatedText();

        // click continue button
        signupPage.clickOnContinueBtn();

        // verify that logged in as username is visible
        homePage.loggedUserNameText();

        // click delete account button
        homePage.clickOnAccountDeleteBtn();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        homePage.accountDeletedText();
    }
}
