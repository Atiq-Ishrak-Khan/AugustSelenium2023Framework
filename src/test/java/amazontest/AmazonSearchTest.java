package amazontest;
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTest extends SetUp {
    @Test
    public void test() {
        //validate the title
        String currentTitle = driver.getTitle();
        Assert.assertEquals("Amazon.com. Spend less. Smile more.",currentTitle);
        System.out.println("amazon main page loaded success");

        //type "java book" in search field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        System.out.println("type java book on the search field success");

        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        String currentText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span[2]/div/h1/div/div[1]/div/div/span[1]")).getText();
        System.out.println("text is: "+currentText);
        Assert.assertTrue(currentText.contains("results for"));
        System.out.println("search page loaded success");
    }
}
