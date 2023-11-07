package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC08_SelectMen extends CommonAPI {

    //Open Men's Tops Successfully
    @Test
    public void test1() {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//*[@id=\'ui-id-5\']");

        clickButton("//a[text()='Tops']");


    }

    @Test
    public void test2() {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//*[@id=\'ui-id-5\']");

        clickButton("//a[text()='Bottoms']");
    }
}


