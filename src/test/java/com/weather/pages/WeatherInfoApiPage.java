package com.weather.pages;

import com.weather.utils.APIConstants;
import com.weather.utils.Context;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import static io.restassured.RestAssured.given;

public class WeatherInfoApiPage extends BasePage {

    public WeatherInfoApiPage(WebDriver driver) {
        super(driver);
    }

    public void getResponseFromAPI(String apiName) {
        String uri = null;
        switch (apiName) {
            case "weatherCityApi":
                uri = APIConstants.WEATHER_CITY;
                break;
        }
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(uri)
                .then()
                .extract().response();
        switch (apiName) {
            case "weatherCityApi":
                Context.setWeatherCityApiResponse(response);
                break;
        }
        System.out.println(response.asString());
    }

    public String getTemperatureFromWeatherCityApi() {
        return Context.getWeatherCityApiResponse().getBody().jsonPath().get(APIConstants.WEATHER_CITY_TEMP_PATH);
    }
}
