package com.weather.utils;

import io.restassured.response.Response;

public class Context {

    private static Response weatherCityApiResponse;

    public static Response getWeatherCityApiResponse() {
        return weatherCityApiResponse;
    }

    public static void setWeatherCityApiResponse(Response weatherCityApi) {
        weatherCityApiResponse = weatherCityApi;
    }
}
