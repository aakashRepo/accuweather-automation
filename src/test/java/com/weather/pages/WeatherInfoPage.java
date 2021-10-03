package com.weather.pages;

import com.weather.utils.CommonFunctions;
import com.weather.utils.InvalidRangeException;
import com.weather.constants.TestConstants;
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
        String tempUi = CommonFunctions.getText(driver, temperature);
        return tempUi.replaceAll("[^0-9]", "");
    }

    public void verifyTemperatureDifferenceRangeValue(String ui, String api) throws InvalidRangeException {
        Float tempUi = Float.parseFloat(ui);
        Float tempApi = Float.parseFloat(api);
        float diff = tempApi - tempUi;
        if (diff != 0) {
            diff = (diff < 0 ? -diff : diff);
            if (!((diff > TestConstants.minTemp) && (diff < TestConstants.maxTemp))) {
                System.out.println("TempApi: " + tempApi + " TempUI:" + tempUi);
                throw new InvalidRangeException("Temperature difference from UI and API doesn't fall in expected Range. TempApi: " + tempApi + " TempUI:" + tempUi);
            }
        }
        System.out.println("Temperature from UI and API is same");
    }
}
