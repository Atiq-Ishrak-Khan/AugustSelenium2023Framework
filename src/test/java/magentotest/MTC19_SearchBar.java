package magentotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MTC19_SearchBar extends CommonAPI {

    @Test
    public void test() {

        input("//input[@id=\"search\"]","purple");

        clickButton("//button[@class=\"action search\"]");

    }
}
