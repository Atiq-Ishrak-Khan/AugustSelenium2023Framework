package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC18_ViewOrders extends CommonAPI {

    @Test
    public void test() {
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        clickButton("//button[@class='action switch']");

        clickButton("//a[text()='My Account']");

        clickButton("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a");

        clickButton("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/a[1]");

    }
}
