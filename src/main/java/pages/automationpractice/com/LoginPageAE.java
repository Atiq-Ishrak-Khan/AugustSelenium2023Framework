package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPageAE.class.getName());

    public LoginPageAE(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //objects (web elements)
    @FindBy(xpath = "//div[@class='login-form']/h2")
    WebElement loginTitleElement;

    //objects (web elements)
    @FindBy(name = "email")
    WebElement emailFieldElement;

    @FindBy(name = "password")
    WebElement passwordFieldElement;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;

    //reusable steps
    public String loginTextTitle(){
        String loginTitleText = getElementText(loginTitleElement);
        LOG.info("login form title text: "+loginTitleText);
        return loginTitleText;
    }

    public void typeEmail(String email){
        type(emailFieldElement, email);
        LOG.info("type email success");
    }

    public void typePassword(String password){
        type(passwordFieldElement, password);
        LOG.info("type password success");
    }

    public void clickOnLoginBtn(){
        clickOn(loginBtn);
        LOG.info("click on login button success");
    }
}
