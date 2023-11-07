package pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAE extends CommonAPI {
    private Logger LOG = LogManager.getLogger(HomePageAE.class.getName());

    public HomePageAE(WebDriver driver) {
        super(driver);
    }

    // Web Elements (Page Objects)
    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    private WebElement sectionTitle;

    @FindBy(xpath = "//a[text()=' Login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@href='/contactus']")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//span[@class='customer-username']")
    private WebElement loggedUserName;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//h2/b")
    private WebElement testCaseTitle;

    @FindBy(xpath = "//h2[text()='Recommended items']")
    private WebElement recommendedItemsTitle;

    @FindBy(xpath = "//a[@data-productid='2']")
    private WebElement recommendedItemLink;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    private WebElement downloadInvoiceLink;

    @FindBy(xpath = "//div[@class='message-success']")
    private WebElement successMessageElement;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement subscribeEmailField;

    @FindBy(xpath = "//button[@id='newsletter-subscribe-button']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[@id='newsletter-result-block']")
    private WebElement subscribeResultBlock;

    // Reusable methods
    public String getSectionTitleText() {
        String pageSectionText = getElementText(sectionTitle);
        LOG.info("Section title text: " + pageSectionText);
        return pageSectionText;
    }

    public void clickOnLoginLink() {
        clickOn(loginLink);
        LOG.info("Clicked on Login link successfully");
    }

    public void clickOnContactUsLink() {
        clickOn(contactUsLink);
        LOG.info("Clicked on Contact Us link successfully");
    }

    public void clickOnCartLink() {
        clickOn(cartLink);
        LOG.info("Clicked on Cart link successfully");
    }

    public String getLoggedUserName() {
        String userName = getElementText(loggedUserName);
        LOG.info("Logged user name: " + userName);
        return userName;
    }

    public void clickOnLogoutLink() {
        clickOn(logoutLink);
        LOG.info("Clicked on Logout link successfully");
    }

    public String getTestCaseTitleText() {
        String titleText = getElementText(testCaseTitle);
        LOG.info("Test case title text: " + titleText);
        return titleText;
    }

    public String getRecommendedItemsTitleText() {
        String titleText = getElementText(recommendedItemsTitle);
        LOG.info("Recommended items title: " + titleText);
        return titleText;
    }

    public void clickOnRecommendedItemLink() {
        clickOn(recommendedItemLink);
        LOG.info("Clicked on Recommended item link successfully");
    }

    public void clickOnDownloadInvoiceLink() {
        clickOn(downloadInvoiceLink);
        LOG.info("Clicked on Download Invoice link successfully");
    }

    public String getSuccessMessage() {
        String successMessage = getElementText(successMessageElement);
        LOG.info("Success message visible: " + successMessage);
        return successMessage;
    }

    public void enterSubscribeEmail(String email) {
        type(subscribeEmailField, email);
        LOG.info("Entered subscription email: " + email);
    }

    public void clickOnSubscribeButton() {
        clickOn(subscribeButton);
        LOG.info("Clicked on Subscribe button successfully");
    }

    public String getSubscribeResultText() {
        String resultText = getElementText(subscribeResultBlock);
        LOG.info("Subscribe result text: " + resultText);
        return resultText;
    }

    public void generateReport(String firstName, String lastName, String email, String password) {
    }

    public void clickOnAccountDeleteBtn() {
    }

    public void subscriptionLabelText() {
    }

    public void clickOnScrollUpBtn() {
    }

    public void verifyMainCarouselContentText() {
    }
}

