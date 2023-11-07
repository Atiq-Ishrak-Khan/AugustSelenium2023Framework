package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC09_SelectGear extends CommonAPI {

    //Open Gear's Bags Successfully
    @Test
    public void test1() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(6000);

        clickButton("//*[@id=\"ui-id-6\"]");

        clickButton("//a[text()='Bags']");

    }

    //Open Gear's Fitness Equipment Successfully
    @Test
    public void test2() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(6000);

        clickButton("//*[@id=\"ui-id-6\"]");

        clickButton("//a[text()='Fitness Equipment']");

    }

    //Open Gear's Watches Successfully
    @Test
    public void test3() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(3000);

        clickButton("//*[@id=\"ui-id-6\"]");

        Thread.sleep(3000);

        clickButton("//a[text()='Watches']");
    }
}
