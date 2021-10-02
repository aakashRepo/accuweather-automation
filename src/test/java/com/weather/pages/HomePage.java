package com.weather.pages;

import com.weather.utils.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@class='search-input']")
    private static By searchBox;
    @FindBy(xpath = "//div[@class='results-container']/div[1]")
    private static By searchResult;
    @FindBy(xpath = "//div[@id='privacy-policy-banner']//div[text()='I Understand']")
    private static By acceptCookie;

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
        return CommonFunctions.isElementDisplayed(driver, searchBox);
    }

    public void searchCity(String city) {
        CommonFunctions.enterText(driver, searchBox, city);
        CommonFunctions.waitTillElementDisplayed(driver, searchResult);
        CommonFunctions.clickElement(driver, searchResult);
    }

}
