package com.weather.utils;

public class FahrenheitToCelcius {

  public static String convertFahrenheitToCelcius(Float temp){
      Float tempF = temp*5;
      tempF = tempF/9;
      return String.valueOf(tempF);
  }
}
