package com.github.atf.tests;

import com.github.atf.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTheTest extends DriverBase {

    @Test(groups = "Test")
    public void searchOnGoogle() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com/");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Random String");
        searchBar.sendKeys(Keys.ENTER);
        driver.wait();
        wait(3000);
        Assert.assertTrue(true);
    }
}