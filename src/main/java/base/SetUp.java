package base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
    public WebDriver driver;
    @Before
    public  void setUp(){
        //launch the browser
        driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https://www.saucedemo.com/");
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
