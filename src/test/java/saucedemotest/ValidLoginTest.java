package saucedemotest;
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ValidLoginTest extends SetUp {

    @Test
    public void test1() {
        // Find the username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        System.out.println("username field found");
        WebElement passwordField = driver.findElement(By.id("password"));
        System.out.println("password field found");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        System.out.println("login button found");

        // Enter a valid username and password
        usernameField.sendKeys("standard_user");
        System.out.println("type username success");
        passwordField.sendKeys("secret_sauce");
        System.out.println("type password success");

        // Click the login button
        loginButton.click();
        System.out.println("click on login button success");

        //Check if the login is successful
        String expectedHeader = "Products";
        String actualHeader =  driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(expectedHeader, actualHeader);
        System.out.println("login to saucedemo app success");
    }
}
