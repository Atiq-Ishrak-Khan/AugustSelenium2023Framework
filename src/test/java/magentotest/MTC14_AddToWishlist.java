package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC14_AddToWishlist extends CommonAPI {
    //Open Women's Tops Successfully
    @Test
    public void test() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(6000);

        clickButton("//*[@id=\"ui-id-4\"]");

        clickButton("//a[text()='Jackets']");

        clickButton("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/strong/a");

        clickButton("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]");




    }

}
