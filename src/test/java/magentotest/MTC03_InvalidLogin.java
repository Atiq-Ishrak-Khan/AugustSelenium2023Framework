package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC03_InvalidLogin extends CommonAPI {

    //invalid password successfully
    @Test
    public void test1(){
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']","clara_oswald@gmail.com");
        input("//input[@id='pass']","");

        clickButton("//button[@class='action login primary']");

    }
    //invalid username successfully
    @Test
    public void test2(){
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']","");
        input("//input[@id='pass']","Clara@123Test");

        clickButton("//button[@class='action login primary']");

    }
}
