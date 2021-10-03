package com.weather.pages;

import com.weather.constants.APIConstants;
import com.weather.utils.Context;
import com.weather.utils.PropertiesUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import static io.restassured.RestAssured.given;

public class WeatherInfoApiPage extends BasePage {

    public WeatherInfoApiPage(WebDriver driver) {
        super(driver);
    }

    public void getResponseFromAPI(String apiName) {
        Response response = null;
        String uri = null;
        switch (apiName) {
            case "weatherCityApi":
                uri = APIConstants.WEATHER_CITY;
                response = given()
                        .contentType(ContentType.JSON)
                        .when().param("q", PropertiesUtil.getProperty("city")).param("appid", APIConstants.API_KEY)
                        .get(uri)
                        .then()
                        .extract().response();
                break;
        }
        switch (apiName) {
            case "weatherCityApi":
                Context.setWeatherCityApiResponse(response);
                break;
        }
        System.out.println(response.asString());
    }

    public Float getTemperatureFromWeatherCityApi() {
        return Context.getWeatherCityApiResponse().getBody().jsonPath().get(APIConstants.WEATHER_CITY_TEMP_PATH);
    }
}
