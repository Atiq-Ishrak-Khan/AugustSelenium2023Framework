package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC07_SelectWomen extends CommonAPI {

    //Open Women's Tops Successfully
    @Test
    public void test() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']","clara_oswald@gmail.com");
        input("//input[@id='pass']","Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(6000);

        clickButton("//*[@id=\"ui-id-4\"]");

        clickButton("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");

        clickButton("//a[text()='Tops']");

    }
    //Open Women's Bottoms Successfully
    @Test
    public void test2() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']","clara_oswald@gmail.com");
        input("//input[@id='pass']","Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(6000);

        clickButton("//*[@id=\"ui-id-4\"]");

        clickButton("//a[text()='Bottoms']");

    }

}
