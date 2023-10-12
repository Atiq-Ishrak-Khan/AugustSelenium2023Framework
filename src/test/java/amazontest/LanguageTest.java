package amazontest;

import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LanguageTest extends SetUp {
    @Test
    public void test1() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']"));
        actions.moveToElement(element).build().perform();
        Thread.sleep(3000);
    }
}
