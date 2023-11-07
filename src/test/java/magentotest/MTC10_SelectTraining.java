package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC10_SelectTraining extends CommonAPI {

    //Open Training Video Download Successfully
    @Test
    public void test() throws InterruptedException {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(3000);

        clickButton("//*[@id=\"ui-id-7\"]");

        clickButton("//a[text()='Video Download']");
    }
}
