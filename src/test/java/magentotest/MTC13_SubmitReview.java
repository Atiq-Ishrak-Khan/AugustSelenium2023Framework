package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC13_SubmitReview extends CommonAPI {

    //Add a Review Successfully
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(6000);

        clickButton("//*[@id=\"ui-id-4\"]");

        clickButton("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");

        clickButton("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[8]/div/div/strong/a");

        clickButton("//a[@class='action add']");

        input("//*[@id=\"Rating_5\"]","5 stars");

        input("//input[@id='summary_field']","Such a cute top");

        input("//textarea[@id='review_field']","Despite what the other reviews say, " +
                "I absolutely adored this top and am exited to work out in it");

        clickButton("//button[@class='action submit primary']");

    }

    //Click on Reviews Successfully
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");

        WebElement registerButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        registerButton.click();

        input("//input[@id='email']", "clara_oswald@gmail.com");
        input("//input[@id='pass']", "Clara@123Test");

        clickButton("//button[@class='action login primary']");

        Thread.sleep(6000);

        clickButton("//*[@id=\"ui-id-4\"]");

        clickButton("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");

        clickButton("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[8]/div/div/strong/a");

        clickButton("//a[@class='action view']");

    }
}
