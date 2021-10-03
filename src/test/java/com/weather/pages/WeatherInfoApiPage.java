package com.weather.pages;

import com.weather.constants.APIConstants;
import com.weather.utils.Context;
import com.weather.utils.PropertiesUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import static io.restassured.RestAssured.given;

@Log4j2
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
        log.info(response.asString());
    }

    public Float getTemperatureFromWeatherCityApi() {
        log.info("get temperature value from Api response");
        return Context.getWeatherCityApiResponse().getBody().jsonPath().get(APIConstants.WEATHER_CITY_TEMP_PATH);
    }
}
