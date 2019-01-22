package com.github.atf.tests;

import com.github.atf.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestTheTest extends DriverBase {

    @Test(groups = "Test")
    public void searchOnGoogle() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Random String");
    }
}