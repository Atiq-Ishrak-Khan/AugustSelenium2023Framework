package pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(ContactUsPageAE.class.getName());

    public ContactUsPageAE(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Web Elements (Page Objects)
    @FindBy(xpath = "(//h2[@class='title text-center'])[2]")
    private WebElement getInTouchTitle;

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "subject")
    private WebElement subjectField;

    @FindBy(id = "enquiry")
    private WebElement messageField;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadFileElement;

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement successMessageAlertElement;

    @FindBy(xpath = "//a[@class='button-2 news-list']")
    private WebElement homeBtnElement;

    // Reusable methods
    public String getGetInTouchTitleText() {
        String getInTouchText = getElementText(getInTouchTitle);
        LOG.info("Get in touch text: " + getInTouchText);
        return getInTouchText;
    }

    public void typeName(String name) {
        type(nameField, name);
        LOG.info("Typed name successfully");
    }

    public void typeEmail(String email) {
        type(emailField, email);
        LOG.info("Typed email successfully");
    }

    public void typeSubject(String subject) {
        type(subjectField, subject);
        LOG.info("Typed subject successfully");
    }

    public void typeMessage(String message) {
        type(messageField, message);
        LOG.info("Typed message successfully");
    }

    public void uploadFile(String filePath) {
        type(uploadFileElement, filePath);
        LOG.info("Uploaded file successfully");
    }

    public void clickOnSubmitBtn() {
        clickOn(submitBtn);
        LOG.info("Clicked on submit button successfully");
    }

    public String getSuccessMessageAlertText() {
        String successMessageAlert = getElementText(successMessageAlertElement);
        LOG.info("Success message text: " + successMessageAlert);
        return successMessageAlert;
    }

    public void clickOnHomeBtn() {
        clickOn(homeBtnElement);
        LOG.info("Clicked on home button successfully");
    }
}
