package saucedemotest;
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends SetUp {

    @Test
    public void test1(){
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("navigate to saucedemo app success");

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
        passwordField.sendKeys("");
        System.out.println("type password success");

        // Click the login button
        loginButton.click();
        System.out.println("click on login button success");

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Password is required";
        String actualError =  driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedError, actualError);
        System.out.println("validate error message success");
    }
    @Test
    public void test2(){
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("navigate to saucedemo app success");

        // Find the username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        System.out.println("username field found");
        WebElement passwordField = driver.findElement(By.id("password"));
        System.out.println("password field found");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        System.out.println("login button found");

        // Enter a valid username and password
        usernameField.sendKeys("");
        System.out.println("type username success");
        passwordField.sendKeys("secret_sauce");
        System.out.println("type password success");

        // Click the login button
        loginButton.click();
        System.out.println("click on login button success");

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Username is required";
        String actualError =  driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedError, actualError);
        System.out.println("validate error message success");
    }
}