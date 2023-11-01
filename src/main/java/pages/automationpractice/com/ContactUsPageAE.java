package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(ContactUsPageAE.class.getName());

    public ContactUsPageAE(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //objects (web elements)
    @FindBy(xpath = "(//h2[@class='title text-center'])[2]")
    WebElement getInTouchTitle;

    @FindBy(name = "name")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "subject")
    WebElement subjectField;

    @FindBy(id = "message")
    WebElement messageField;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFileElement;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessageAlertElement;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement homeBtnElement;

    //reusable steps
    public String getInTouchTitleText(){
        String getInTouchText = getElementText(getInTouchTitle);
        LOG.info("get in touch text: "+getInTouchText);
        return getInTouchText;
    }

    public void typeName(String name){
        type(nameField, name);
        LOG.info("type name success");
    }

    public void typeEmail(String email){
        type(emailField, email);
        LOG.info("type email success");
    }

    public void typeSubject(String subject){
        type(subjectField, subject);
        LOG.info("type subject success");
    }

    public void typeMessage(String message){
        type(messageField, message);
        LOG.info("type message success");
    }

    public void uploadFile(String filePath){
        type(uploadFileElement, filePath);
        LOG.info("upload file success");
    }

    public void clickOnSubmitBtn(){
        clickOn(submitBtn);
        LOG.info("click on submit button success");
    }

    public String successMessageAlertText(){
        String successMessageAlert = getElementText(successMessageAlertElement);
        // Assert.assertEquals(actualValue, expectedValue, "Values are not equal.");
        LOG.info("success message text: "+successMessageAlert);
        return successMessageAlert;
    }

    public void clickOnHomeBtn(){
        clickOn(homeBtnElement);
        LOG.info("click on home button success");
    }
}
