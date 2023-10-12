package amazontest;

import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectProductTest extends SetUp {

    @Test
    public void test1() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Baby");
        System.out.println("baby department is selected");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bed");
        System.out.println("type bed on the search field success");
        Thread.sleep(3000);
    }
}
