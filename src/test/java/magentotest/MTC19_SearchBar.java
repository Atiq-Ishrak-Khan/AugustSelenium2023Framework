package magentotest;

import base.CommonAPI;
import org.testng.annotations.Test;

public class MTC19_SearchBar extends CommonAPI {

    @Test
    public void test() {
        driver.get("https://magento.softwaretestingboard.com/");

        input("//input[@id=\"search\"]","purple");

        clickButton("//button[@class=\"action search\"]");

    }
}
