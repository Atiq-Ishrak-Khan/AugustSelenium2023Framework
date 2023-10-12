package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class SetUp {
    public WebDriver driver;

    @Parameters({"url","browserName"})
    @BeforeMethod
    public  void setUp(String url, String browserName) {
        if (browserName.equalsIgnoreCase("chrome")){
            //launch the browser
            driver = new ChromeDriver();
            System.out.println("chrome browser launched");
        }else if (browserName.equalsIgnoreCase("firefox")){
            //launch the browser
            driver = new FirefoxDriver();
            System.out.println("firefox browser launched");
        }else if (browserName.equalsIgnoreCase("edge")){
            //launch the browser
            driver = new EdgeDriver();
            System.out.println("edge browser launched");
        }

        //Maximize window
        driver.manage().window().maximize();
        System.out.println("window maximize");
        //set the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("implicit wait set up");

        // Navigate to the website
        driver.get(url);
        System.out.println("navigate to "+url+" ...");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        System.out.println("browser close success");
    }
}
