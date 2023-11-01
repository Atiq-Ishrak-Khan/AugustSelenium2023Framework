package pages.automationpractice.com;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAE extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePageAE.class.getName());

    public HomePageAE(WebDriver driver) {
        super(driver);
    }

    //objects (web elements)
    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    WebElement sectionTitle;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement loginSignupLink;

    @FindBy(xpath = "//a[@href='/contact_us']")
    WebElement contactUsLink;

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement cartLink;

    @FindBy(xpath = "//li/a/i[@class='fa fa-user']/following-sibling::b")
    WebElement loggedUserName;

    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement accountDeleteBtn;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutBtn;

    @FindBy(xpath = "//a[@href='/test_cases']")
    WebElement testCasesBtn;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']/b")
    WebElement accountDeletedTextElement;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    WebElement downloadInvoiceBtn;

    @FindBy(xpath = "//div[@class='login-form']//p")
    WebElement incorrectLoginAlertTextElement;

    @FindBy(xpath = "//div[@class='signup-form']//p")
    WebElement signupFailedAlertTextElement;

    @FindBy(xpath = "//h2/b")
    WebElement testCaseTitleElement;

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    WebElement subscriptionFieldLabel;

    @FindBy(id = "susbscribe_email")
    WebElement susbscribeEmailField;

    @FindBy(id = "subscribe")
    WebElement susbscribeArrowBtn;

    @FindBy(xpath = "//div[@id='success-subscribe']/div")
    WebElement susbscribeSuccessAlert;

    @FindBy(xpath = "//h2[text()='recommended items']")
    WebElement recommendedItemsSectionElement;

    @FindBy(xpath = "//div[@class='recommended_items']//a[@data-product-id='2']")
    WebElement aRecommendedItemElement;

    @FindBy(id = "scrollUp")
    WebElement scrollUpElement;

    @FindBy(xpath = "(//div[@class='carousel-inner']/div/div/h2)[1]")
    WebElement mainCarouselContent;

    //reusable steps
    public String getSectionTitleText(){
        String pageSectionText = getElementText(sectionTitle);
        LOG.info("section title text: "+pageSectionText);
        return pageSectionText;
    }

    public void clickOnSignupLoginLink(){
        clickOn(loginSignupLink);
        LOG.info("click on signup - login link success");
    }

    public void clickOnContactUsLink(){
        clickOn(contactUsLink);
        LOG.info("click on contact us link success");
    }

    public void clickOnCartLink(){
        clickOn(cartLink);
        LOG.info("click on cart link success");
    }

    public String loggedUserNameText(){
        String loggedUserNameText = getElementText(loggedUserName);
        LOG.info("logged user name text visible: "+loggedUserNameText);
        return loggedUserNameText;
    }

    public void clickOnAccountDeleteBtn(){
        clickOn(accountDeleteBtn);
        LOG.info("click on account delete button success");
    }

    public void clickOnLogoutBtn(){
        clickOn(logoutBtn);
        LOG.info("click on logout button success");
    }

    public void clickOnTestCasesBtn(){
        clickOn(testCasesBtn);
        LOG.info("click on test cases success");
    }

    public String accountDeletedText(){
        String accountDeletedText = getElementText(accountDeletedTextElement);
        LOG.info("account deleted text visible: "+accountDeletedText);
        return accountDeletedText;
    }

    public String incorrectLoginAlertText(){
        String incorrectLoginAlertText = getElementText(incorrectLoginAlertTextElement);
        LOG.info("incorrect login alert visible: "+incorrectLoginAlertText);
        return incorrectLoginAlertText;
    }

    public String signupFailedAlertText(){
        String signupFailedAlertText = getElementText(signupFailedAlertTextElement);
        LOG.info("failed signup alert visible: "+signupFailedAlertText);
        return signupFailedAlertText;
    }

    public String testCaseTitleText(){
        String testCaseTitle = getElementText(testCaseTitleElement);
        LOG.info("test case title visible: "+testCaseTitle);
        return testCaseTitle;
    }

    public void scrollToDown(){
        scrollToBottom();
        LOG.info("scroll down to footer success");
    }

    public void scrollToUp(){
        scrollUp();
        LOG.info("scroll up to top success");
    }

    public void scrollToRecommendedItemsSection(){
        scrollToSection(recommendedItemsSectionElement);
        LOG.info("scroll to recommended items section success");
    }

    public String getRecommendedItemsTitleText(){
        String recommendedItemsText = getElementText(recommendedItemsSectionElement);
        LOG.info("section title text: "+recommendedItemsText);
        return recommendedItemsText;
    }

    public String subscriptionLabelText(){
        String subscriptionLabel = getElementText(subscriptionFieldLabel);
        LOG.info("subscription title visible: "+subscriptionLabel);
        return subscriptionLabel;
    }

    public void typeSubscriptionEmail(String email){
        type(susbscribeEmailField, email);
        LOG.info("type susbscribe email success");
    }

    public void clickOnSubscriptionArrowBtn(){
        clickOn(susbscribeArrowBtn);
        LOG.info("click on subscription button success");
    }

    public void clickOnARecommendedItemBtn(){
        clickOn(aRecommendedItemElement);
        LOG.info("click on a recommended item button success");
    }

    public void clickOnScrollUpBtn(){
        clickOn(scrollUpElement);
        LOG.info("click on scroll up button success");
    }

    public void clickOnContinueBtn(){
        clickOn(continueBtn);
        LOG.info("click on continue button success");
    }

    public void clickOnDownloadInvoiceBtn(){
        clickOn(downloadInvoiceBtn);
        LOG.info("click on download invoice button success");
    }

    public String verifySubscriptionSuccessAlert(){
        String subscriptionAlert = getElementText(susbscribeSuccessAlert);
        LOG.info("subscription success message visible: "+subscriptionAlert);
        return subscriptionAlert;
    }

    public String verifyMainCarouselContentText(){
        String mainCarouselText = getElementText(mainCarouselContent);
        LOG.info("main carousel 'Full-Fledged' text visible: "+mainCarouselText);
        return mainCarouselText;
    }
}
