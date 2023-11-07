package magentotest;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC01_CreateNewAccount extends CommonAPI {
    Logger LOG = LogManager.getLogger(MTC01_CreateNewAccount.class.getName());

    //open create an account page successfully
    @Test
    public void test1() {
        WebElement registerButton = driver.findElement(By.xpath("//a[text()='Create an Account']"));
        registerButton.click();
        LOG.info("Open Create an Account page success");

    }

    //open Create the account successfully
    @Test
    public void test2() {
        WebElement registerButton = driver.findElement(By.xpath("//a[text()='Create an Account']"));
        registerButton.click();
        //LOG.info("Open Create an Account page success");
        input("//input[@id='firstname']","clara");
        input("//input[@id='lastname']","oswald");
        input("//input[@id='email_address']","clara_oswald@gmail.com");
        input("//input[@id='password']","Clara@123Test");
        input("//input[@id='password-confirmation']","Clara@123Test");

        clickButton("//button[@class='action submit primary']");

    }


}
