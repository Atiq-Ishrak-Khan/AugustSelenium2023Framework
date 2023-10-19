package saucedemotest;
import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelReader;


public class ValidLoginTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(ValidLoginTest.class.getName());
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");
    ExcelReader excelReader = new ExcelReader("C:\\Users\\PNT\\eclipse-workspace\\Aug2023SeleniumProject1\\data\\data.xlsx", "Data");

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Enter a valid username and password
        loginPage.typeUsername(username);
        loginPage.typePassword(password);

        // Click the login button
        loginPage.clickOnLoginBtn();

        //Check if the login is successful
        String expectedHeader = excelReader.getCellValueForGivenKey("Home Page Header");
        String actualHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHeader, actualHeader);
        LOG.info("login to saucedemo app success");
    }
}
