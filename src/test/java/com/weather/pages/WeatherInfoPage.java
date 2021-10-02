package com.weather.pages;

import com.weather.utils.CommonFunctions;
import com.weather.utils.InvalidRangeException;
import com.weather.utils.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherInfoPage extends BasePage {

    @FindBy(xpath = "//div[@class='cur-con-weather-card__panel']//div[@class='forecast-container']/div[@class='temp-container']/div[@class='temp']")
    public static WebElement temperature;

    public WeatherInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyUserLandedOnWeatherForecastPage() {
        return CommonFunctions.isElementDisplayed(driver, temperature);
    }

    public String getTemperatureFromUI() {
        return CommonFunctions.getText(driver, temperature);
    }

    public Boolean verifyTemperatureDifferenceRangeValue(String ui, String api) {
        try {
            int tempUi = Integer.parseInt(ui);
            int tempApi = Integer.parseInt(api);
            if (tempApi - tempUi != 0) {
                if (tempApi - tempUi > 0) {
                    if (!(tempApi - tempUi > TestConstants.minTemp) && (tempApi - tempUi < TestConstants.maxTemp)) {
                        throw new InvalidRangeException("Temperature difference from UI and API doesn't fall in expected Range");
                    }
                } else if (tempUi - tempApi > 0) {
                    if (!(tempUi - tempApi > TestConstants.minTemp) && (tempUi - tempApi < TestConstants.maxTemp)) {
                        throw new InvalidRangeException("Temperature difference from UI and API doesn't fall in expected Range");
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
