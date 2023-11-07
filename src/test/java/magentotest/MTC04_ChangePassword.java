package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC04_ChangePassword extends CommonAPI {

    //change password successfully
    @Test
    public void test1() {
        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("//a[text()='My Account']");

        clickButton("//a[@class='action change-password']");

        input("//input[@name='current_password']","Clara@123Test");
        input("//input[@name='password']","Clara@123Test");
        input("//input[@name='password_confirmation']","Clara@123Test");

        clickButton("//button[@class='action save primary']");
    }

}
