package pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(LoginPageAE.class.getName());

    public LoginPageAE(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Web Elements (Page Objects)
    @FindBy(xpath = "//div[@class='page-title']/h1")
    private WebElement loginTitleElement;

    @FindBy(id = "Email")
    private WebElement emailFieldElement;

    @FindBy(id = "Password")
    private WebElement passwordFieldElement;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginBtn;

    // Reusable methods
    public String getLoginTitleText() {
        String loginTitleText = getElementText(loginTitleElement);
        LOG.info("Login form title text: " + loginTitleText);
        return loginTitleText;
    }

    public void typeEmail(String email) {
        type(emailFieldElement, email);
        LOG.info("Typed email successfully");
    }

    public void typePassword(String password) {
        type(passwordFieldElement, password);
        LOG.info("Typed password successfully");
    }

    public void clickOnLoginBtn() {
        clickOn(loginBtn);
        LOG.info("Clicked on login button successfully");
    }

   // public String loginTextTitle() {
    //}

    //public String loginTextTitle() {
   // }

    //public String getTime() {
       // return time;
    //}

   // public void setTime(String time) {
        //this.time = time;
   // }

    // public String loginTextTitle() {
    //}

    //public String loginTextTitle() {
    //}
}
