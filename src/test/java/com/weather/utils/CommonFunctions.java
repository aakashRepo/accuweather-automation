package com.weather.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;

public class CommonFunctions {

    public static void waitTillElementDisplayed(WebDriver driver, By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TestConstants.EXPLICIT_WAIT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(WebDriver driver, By element) {
        driver.findElement(element).click();
    }

    public static boolean isElementDisplayed(WebDriver driver, By element) {
        return driver.findElement(element).isDisplayed();
    }

    public static String getText(WebDriver driver, By element){
        return driver.findElement(element).getText();
    }

    public static void enterText(WebDriver driver, By element, String text){
        driver.findElement(element).sendKeys(text);
    }

}
