package saucedemo;
import base.SetUp;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InvalidLogin extends SetUp {

    @Test
    public void test1(){
        // Find the username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter a valid username and password
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("");

        // Click the login button
        loginButton.click();

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Password is required";
        String actualError =  driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedError, actualError);
    }
    @Test
    public void test2(){
        // Find the username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter a valid username and password
        usernameField.sendKeys("");
        passwordField.sendKeys("secret_sauce");

        // Click the login button
        loginButton.click();

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedUsernameError = "Epic sadface: Username is required";
        String actualUsernameError =  driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedUsernameError, actualUsernameError);
    }
}