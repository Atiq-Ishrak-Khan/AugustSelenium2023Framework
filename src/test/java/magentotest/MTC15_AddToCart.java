package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC15_AddToCart extends CommonAPI {

    @Test
    public void test() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(3000);

        clickButton("//*[@id=\"ui-id-4\"]");

        clickButton("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");

        clickButton("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[8]/div/div/strong/a");

        Thread.sleep(6000);

        clickButton("//*[@id=\"option-label-size-143-item-168\"]");
        clickButton("//*[@id=\"option-label-color-93-item-56\"]");

        clickButton("//button[@class='action primary tocart']");

    }
}
