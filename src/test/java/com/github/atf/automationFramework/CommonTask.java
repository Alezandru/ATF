package com.github.atf.automationFramework;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CommonTask {
    /**
     *
     * @param element - locator (WebElement)
     * @param elementName - element name
     */
    public static void clearElement(WebElement element, String elementName) {
        try {
            Log4Test.info("- clearing field : " + elementName);
            element.clear();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }

    }

    /**
     *
     * @param driver - driver instance
     * @param element - locator (WebElement)
     * @param elementName - element name
     */
    public static void moveToElement(WebDriver driver, WebElement element, String elementName) {
        try {
            Actions action = new Actions(driver);
            Log4Test.info("- moving to element : " + elementName);
            action.moveToElement(element).build().perform();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }
    }

    /**
     *
     * @param element - locator (WebElement)
     * @param text - text to be sent to element
     * @param elementName - element name
     */
    public static void sendKeys(WebElement element, String text, String elementName) {
        try {
            Log4Test.info("- sending keys : '" + text + "' : to " + elementName);
            //clearElement(element, elementName);
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }

    }


    /**
     *
     * @param driver - driver instance
     * @param element - locator (WebElement)
     * @param elementName - element name
     */
    public static void clickElement(WebDriver driver, WebElement element, String elementName) {
        try {
            //Waiting for the element to be available
            Waiting.elementToBeClickable(driver, element, elementName);
            //Move to element
            moveToElement(driver, element, elementName);
            Log4Test.info("- clicking element : " + elementName);
            //Click Element
            element.click();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }
    }

    public static void waitForElement(WebDriver driver, WebElement element, String elementName) {
        try {
            //Waiting for the element to be available
            Waiting.elementToBeClickable(driver, element, elementName);


        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }
    }
}
