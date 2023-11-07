package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MTC05_ManageAddresses extends CommonAPI {

    //select manage addresses successfully
    @Test
    public void test1() {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("//a[text()='My Account']");

        clickButton("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[1]/a");

    }

    //add a new address successfully
    @Test
    public void test2() {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("//a[text()='My Account']");

        clickButton("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[1]/a");

        input("//input[@id='company']","Tardis.Co");
        input("//input[@id='telephone']","9176666666");
        input("//input[@id='street_1']","timeywimey PL");
        input("//input[@id='city']","BadWolf");
        Select se = new Select(driver.findElement(By.xpath("//*[@id=\"region_id\"]")));
        se.selectByValue("43");
       // WebElement selectCity = driver.findElement(By.xpath("//*[@id=\"region_id\"]/option[44]"));
        input("//input[@id='zip']","66666");


        clickButton("//button[@class='action save primary']");


    }
}
