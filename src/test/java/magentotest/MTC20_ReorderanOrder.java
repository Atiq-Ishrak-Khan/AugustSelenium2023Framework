package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC20_ReorderanOrder extends CommonAPI {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("//a[text()='My Account']");

        clickButton("//a[@class='action order']");

        clickButton("//button[@class='action primary checkout']");

        Thread.sleep(16000);

        clickButton("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[2]/td[1]");

        clickButton("//button[@class='button action continue primary']");

        Thread.sleep(6000);

        clickButton("//button[@class='action primary checkout']");


    }

}
