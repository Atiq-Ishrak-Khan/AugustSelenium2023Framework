package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC06_DropDownMenuSelect extends CommonAPI {

    //select My Account option successfully
    @Test
    public void test1() {
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("//a[text()='My Account']");

    }

    //select My Wish List option successfully
    @Test
    public void test2() {
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("//a[text()='My Wish List ']");

    }
    //select sign out option successfully
    @Test
    public void test3() {
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a[1]");
    }
}