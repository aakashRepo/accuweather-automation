package com.weather.tests;

import com.weather.pages.HomePage;
import com.weather.pages.WeatherInfoApiPage;
import com.weather.pages.WeatherInfoPage;
import com.weather.utils.FahrenheitToCelcius;
import com.weather.utils.InvalidRangeException;
import com.weather.utils.PropertiesUtil;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Test Class for Validating Weather Info
 *
 * @author Aakash Singh
 * 10/03/2021
 */
public class WeatherInfoTest extends BaseTest {

    @Test
    public void test_validateWeatherInfo_ForCity() throws InvalidRangeException {
        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        WeatherInfoPage weatherInfoPage = new WeatherInfoPage(driver);
        softAssert.assertTrue(homePage.verifyUserLandedOnHomePage(), "user didn't land on homepage");
        homePage.searchCity(PropertiesUtil.getProperty("city"));
        softAssert.assertTrue(weatherInfoPage.verifyUserLandedOnWeatherForecastPage(), "user is not able to searhc city");
        String tempUI = weatherInfoPage.getTemperatureFromUI();
        WeatherInfoApiPage weatherInfoApiPage = new WeatherInfoApiPage(driver);
        weatherInfoApiPage.getResponseFromAPI("weatherCityApi");
        String tempApi = FahrenheitToCelcius.convertFahrenheitToCelcius(weatherInfoApiPage.getTemperatureFromWeatherCityApi());
        softAssert.assertEquals(tempUI, tempApi, "Temperature from UI and API doesn't match");
        weatherInfoPage.verifyTemperatureDifferenceRangeValue(tempUI, tempApi);
        softAssert.assertAll();
    }

}
