package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC02_ValidLoginTest extends CommonAPI {

    //test 1: Verify the URL lands on the correct page
    @Test
    public void test(){
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']","clara_oswald@gmail.com");
        input("//input[@id='pass']","Clara@123Test");

        clickButton("//button[@class='action login primary']");

    }

}
