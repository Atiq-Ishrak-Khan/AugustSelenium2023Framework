package pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(SignupPageAE.class.getName());

    public SignupPageAE(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Web Elements
    @FindBy(xpath = "//div[@class='signup-form']/h2")
    private WebElement newUserSignupElement;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupBtn;

    @FindBy(xpath = "(//h2[@class='title text-center']/b)[1]")
    private WebElement signupPageTitle;

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement mrTitle;

    @FindBy(id = "password")
    private WebElement signupPassword;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement dayOfDob;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthOfDob;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearOfDob;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement offersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInputField;

    @FindBy(id = "last_name")
    private WebElement lastNameInputField;

    @FindBy(id = "company")
    private WebElement companyInputField;

    @FindBy(id = "address1")
    private WebElement address1InputField;

    @FindBy(id = "address2")
    private WebElement address2InputField;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInputField;

    @FindBy(id = "city")
    private WebElement cityInputField;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInputField;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInputField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accountCreatedTextElement;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueBtn;

    // Reusable methods

    public String newUserSignupText() {
        String newUserSignupText = getElementText(newUserSignupElement);
        LOG.info("New signup title text: " + newUserSignupText);
        return newUserSignupText;
    }

    public void typeUsername(String username) {
        type(usernameField, username);
        LOG.info("Typed username successfully");
    }

    public void typeUserEmail(String email) {
        type(userEmailField, email);
        LOG.info("Typed user email successfully");
    }

    public void clickOnSignupBtn() {
        clickOn(signupBtn);
        LOG.info("Clicked on signup button successfully");
    }

    public String signupPageTitleText() {
        String signupTitleText = getElementText(signupPageTitle);
        LOG.info("Signup title text: " + signupTitleText);
        return signupTitleText;
    }

    public void clickOnMrTitle() {
        clickOn(mrTitle);
        LOG.info("Clicked on Mr title button successfully");
    }

    public void typePassword(String password) {
        type(signupPassword, password);
        LOG.info("Typed password successfully");
    }

    public void selectDateOfBirth(String day, String month, String year) {
        selectDropdownOption(dayOfDob, day);
        selectDropdownOption(monthOfDob, month);
        selectDropdownOption(yearOfDob, year);
        LOG.info("Selected date of birth successfully");
    }

    public void clickOnNewsletter() {
        clickOn(newsletterCheckbox);
        LOG.info("Clicked on newsletter checkbox successfully");
    }

    public void clickOnOffersCheckbox() {
        clickOn(offersCheckbox);
        LOG.info("Clicked on offers checkbox successfully");
    }

    public void typeFirstName(String firstName) {
        type(firstNameInputField, firstName);
        LOG.info("Typed first name successfully");
    }

    public void typeLastName(String lastName) {
        type(lastNameInputField, lastName);
        LOG.info("Typed last name successfully");
    }

    public void typeCompanyName(String companyName) {
        type(companyInputField, companyName);
        LOG.info("Typed company name successfully");
    }

    public void typePrimaryAddress(String primaryAddress) {
        type(address1InputField, primaryAddress);
        LOG.info("Typed primary address successfully");
    }

    public void typeSecondaryAddress(String secondaryAddress) {
        type(address2InputField, secondaryAddress);
        LOG.info("Typed secondary address successfully");
    }

    public void selectCountry(String countryName) {
        selectDropdownOption(countryDropdown, countryName);
        LOG.info("Selected country successfully");
    }

    public void typeState(String state) {
        type(stateInputField, state);
        LOG.info("Typed state successfully");
    }

    public void typeCity(String city) {
        type(cityInputField, city);
        LOG.info("Typed city successfully");
    }

    public void typeZipCode(String zipcode) {
        type(zipcodeInputField, zipcode);
        LOG.info("Typed zip code successfully");
    }

    public void typeMobileNumber(String mobileNumber) {
        type(mobileNumberInputField, mobileNumber);
        LOG.info("Typed mobile number successfully");
    }

    public void clickOnCreateAccountBtn() {
        clickOn(createAccountBtn);
        LOG.info("Clicked on create account button successfully");
    }

    public String accountCreatedText() {
        String accountCreatedText = getElementText(accountCreatedTextElement);
        LOG.info("Account created text visible: " + accountCreatedText);
        return accountCreatedText;
    }

    public void clickOnContinueBtn() {
        clickOn(continueBtn);
        LOG.info("Clicked on continue button successfully");
    }
}
