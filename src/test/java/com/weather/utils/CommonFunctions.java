package com.weather.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {

    public static void waitTillElementDisplayed(WebDriver driver, By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TestConstants.EXPLICIT_WAIT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public static boolean isElementDisplayed(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    public static String getText(WebDriver driver, WebElement element){
        return element.getText();
    }

    public static void enterText(WebDriver driver, WebElement element, String text){
        element.sendKeys(text);
    }

}
