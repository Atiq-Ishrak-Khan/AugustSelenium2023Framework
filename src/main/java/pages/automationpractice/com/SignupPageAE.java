package pages.automationpractice.com;

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

    //objects (web elements)
    @FindBy(xpath = "//div[@class='signup-form']/h2")
    WebElement newUserSignupElement;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement userEmailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupBtn;

    @FindBy(xpath = "(//h2[@class='title text-center']/b)[1]")
    WebElement signupPageTitle;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement mrTitle;

    @FindBy(id = "password")
    WebElement signupPassword;

    @FindBy(xpath = "//select[@id='days']")
    WebElement dayOfDob;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthOfDob;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearOfDob;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement offersCheckbox;

    @FindBy(id = "first_name")
    WebElement firstNameInputField;

    @FindBy(id = "last_name")
    WebElement lastNameInputField;

    @FindBy(id = "company")
    WebElement companyInputField;

    @FindBy(id = "address1")
    WebElement address1InputField;

    @FindBy(id = "address2")
    WebElement address2InputField;

    @FindBy(id = "country")
    WebElement countryDropdown;

    @FindBy(id = "state")
    WebElement stateInputField;

    @FindBy(id = "city")
    WebElement cityInputField;

    @FindBy(id = "zipcode")
    WebElement zipcodeInputField;

    @FindBy(id = "mobile_number")
    WebElement mobileNumberInputField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountBtn;

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    WebElement accountCreatedTextElement;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueBtn;

    //reusable steps
    public void newUserSignupText(){
        String newUserSignupText = getElementText(newUserSignupElement);
        LOG.info("new signup title text: "+newUserSignupText);
    }

    public void typeUsername(String username){
        type(usernameField, username);
        LOG.info("type username success");
    }

    public void typeUserEmail(String email){
        type(userEmailField, email);
        LOG.info("type user email success");
    }

    public void clickOnSignupBtn(){
        clickOn(signupBtn);
        LOG.info("click on signup button success");
    }

    public String signupPageTitleText(){
        String signupTitleText = getElementText(signupPageTitle);
        LOG.info("signup title text: "+signupTitleText);
        return signupTitleText;
    }

    public void clickOnMrTitle(){
        clickOn(mrTitle);
        LOG.info("click on Mr title button success");
    }

    public void typePassword(String password){
        type(signupPassword, password);
        LOG.info("type password success");
    }

    public void selectDateOfBirth(String day, String month, String year){
        selectDropdownOption(dayOfDob, day);
        selectDropdownOption(monthOfDob, month);
        selectDropdownOption(yearOfDob, year);
        LOG.info("select day of birth success");
    }

    public void clickOnNewsletter(){
        clickOn(newsletterCheckbox);
        LOG.info("click on newsletter checkbox success");
    }

    public void clickOnOffersCheckbox(){
        clickOn(offersCheckbox);
        LOG.info("click on offers checkbox success");
    }

    public void typeFirstName(String firstName){
        type(firstNameInputField, firstName);
        LOG.info("type first name success");
    }

    public void typeLastName(String lastName){
        type(lastNameInputField, lastName);
        LOG.info("type last name success");
    }

    public void typeCompanyName(String companyName){
        type(companyInputField, companyName);
        LOG.info("type company name success");
    }

    public void typePrimaryAddress(String primaryAddress){
        type(address1InputField, primaryAddress);
        LOG.info("type primary address success");
    }

    public void typeSecondaryAddress(String secondaryAddress){
        type(address2InputField, secondaryAddress);
        LOG.info("type secondary address success");
    }

    public void selectCountry(String countryName){
        selectDropdownOption(countryDropdown, countryName);
        LOG.info("select country success");
    }

    public void typeState(String state){
        type(stateInputField, state);
        LOG.info("type state success");
    }

    public void typeCity(String city){
        type(cityInputField, city);
        LOG.info("type city success");
    }

    public void typeZipCode(String zipcode){
        type(zipcodeInputField, zipcode);
        LOG.info("type zip code success");
    }

    public void typeMobileNumber(String mobileNumber){
        type(mobileNumberInputField, mobileNumber);
        LOG.info("type mobile number success");
    }

    public void clickOnCreateAccountBtn(){
        clickOn(createAccountBtn);
        LOG.info("click on create account button success");
    }

    public String accountCreatedText(){
        String accountCreatedText = getElementText(accountCreatedTextElement);
        LOG.info("account created text visible: "+accountCreatedText);
        return accountCreatedText;
    }

    public void clickOnContinueBtn(){
        clickOn(continueBtn);
        LOG.info("click on continue button success");
    }
}
