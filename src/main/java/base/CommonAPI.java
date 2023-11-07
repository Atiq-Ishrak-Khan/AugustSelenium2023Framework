package base;

import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utility.Utility;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class CommonAPI {
    Logger LOG = LogManager.getLogger(CommonAPI.class.getName());
    public Properties prop = Utility.loadProp();
    public WebDriver driver;

    public CommonAPI(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CommonAPI() {
    }

    int implicitWait = Integer.parseInt(prop.getProperty("wait.time", "10"));
    String windowMaximize = prop.getProperty("window.maximize", "true");
    String username = prop.getProperty("browserstack.username");
    String password = prop.getProperty("browserstack.key");

    //String takeScreenshot = Utility.getProperties().getProperty("take.screenshot", "false");
    //String headlessMode = Utility.getProperties().getProperty("headless.mode", "false");

    //report setup from line 48 to 105
    public static com.relevantcodes.extentreports.ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
//        if (takeScreenshot.equalsIgnoreCase("true")){
//            if (result.getStatus() == ITestResult.FAILURE) {
//                takeScreenshot(result.getName());
//            }
//        }
        driver.quit();
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public void getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        if (envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("browser_version", browserVersion);
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@hub-cloud.browserstack.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }
    }

    public void getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addExtensions(new File(getAdBlockExtensionPath()));
            WebDriverManager.chromedriver().setup();
            //launch the browser
            driver = new ChromeDriver(opt);
            LOG.info("chrome browser launched");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            //launch the browser
            driver = new FirefoxDriver();
            LOG.info("firefox browser launched");
            System.out.println();
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions opt = new EdgeOptions();
            opt.addExtensions(new File(getAdBlockExtensionPath()));
            WebDriverManager.edgedriver().setup();
            //launch the browser
            driver = new EdgeDriver(opt);
            LOG.info("edge browser launched");
        }
    }

    @Parameters({"useCloudEnv", "envName", "os", "osVersion", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://www.google.com") String url) throws MalformedURLException {
        if (useCloudEnv) {
            getCloudDriver(os, osVersion, browserName, browserVersion, envName);
        } else {
            getLocalDriver(browserName);
        }
        //Maximize window
        if (windowMaximize.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
            LOG.info("window maximize");
        }

        //set the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        LOG.info("implicit wait set to " + implicitWait);

        // Navigate to the website
        driver.get(url);
        LOG.info("navigate to " + url + " ...");
    }
    //------------------------------------------------------------------------------------------------------------------
    //reusable methods (non page object model methods)
    //------------------------------------------------------------------------------------------------------------------

    public WebDriver getDriver() {
        return driver;
    }

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    //------------------------------------------------------------------------------------------------------------------
    //reusable methods (page object model methods)
    //------------------------------------------------------------------------------------------------------------------
    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToSection(WebElement sectionElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'start'});", sectionElement);
    }

    public void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void hoverOver(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void selectDropdownOption(WebElement element, String option) {
        Select select = new Select(element);
        try {
            select.selectByValue(option);
        } catch (Exception e) {
            select.selectByValue(option);
        }
    }

    public String getRandomMail() {
        // Fixed parts of the email address
        String prefix = "user";
        String domain = "@mail.com";

        // Generate a random number
        int randomNum = new Random().nextInt(100000);

        // Combine the parts to create the random email address
        String randomEmail = prefix + randomNum + domain;

        return randomEmail;
    }

    public void closeAllTabsExceptFirstTab() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // Capture the handle of the first tab (tab0)
        String firstTabHandle = driver.getWindowHandles().toArray()[0].toString();

        // Switch back to the first tab (tab0)
        driver.switchTo().window(firstTabHandle);

        // Get the handle of the current tab (tab0)
        String currentTabHandle = driver.getWindowHandle();

        // Get a list of all open tab handles
        Set<String> allTabHandles = driver.getWindowHandles();

        // Iterate through tab handles and close tabs that are not the current tab
        for (String tabHandle : allTabHandles) {
            if (!tabHandle.equals(currentTabHandle)) {
                driver.switchTo().window(tabHandle);
                driver.close();
            }
        }

        // Optionally, you can continue with other actions on the current tab
        driver.switchTo().window(currentTabHandle);
        driver.navigate().refresh();
    }

    public String getAdBlockExtensionPath() {
        String relativeFilePath = "/src/test/resources/adblock.crx";
        String projectRoot = System.getProperty("user.dir");
        String absoluteFilePath = projectRoot + relativeFilePath;
        return absoluteFilePath;
    }


//noshinara's common apis

    public void input(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void clickButton(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }


    public void type(String cssOrXpath, String text) {
        try {
            driver.findElement(By.cssSelector(text)).sendKeys();
        } catch (Exception e) {
            driver.findElement(By.xpath(text)).sendKeys(text);
        }
    }
}
