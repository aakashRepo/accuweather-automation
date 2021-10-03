package com.weather.pages;

import com.weather.utils.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@class='search-input']")
    public static WebElement searchBox;
    @FindBy(xpath = "//div[@class='results-container']/div[1]")
    public static WebElement searchResult;
    @FindBy(xpath = "//div[@id='privacy-policy-banner']//div[text()='I Understand']")
    public static WebElement acceptCookie;
    @FindBy(xpath = "//*[local-name()='svg' and @class='pro-tip__close close-icon']")
    public static WebElement proTipCloseIcon;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void acceptCookie() {
        if (CommonFunctions.isElementDisplayed(driver, acceptCookie)) {
            CommonFunctions.clickElement(driver, acceptCookie);
        }
    }

    public Boolean verifyUserLandedOnHomePage() {
        acceptCookie();
        closeProTip();
        return CommonFunctions.isElementDisplayed(driver, searchBox);
    }

    public void searchCity(String city) {
        CommonFunctions.clickElement(driver, searchBox);
        CommonFunctions.enterText(driver, searchBox, city);
        CommonFunctions.clickElement(driver, searchResult);
    }

    public void closeProTip() {
        if (CommonFunctions.isElementDisplayed(driver, proTipCloseIcon)) {
            CommonFunctions.clickElement(driver, proTipCloseIcon);
        }
    }

}
