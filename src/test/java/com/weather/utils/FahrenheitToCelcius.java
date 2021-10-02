package com.weather.utils;

public class FahrenheitToCelcius {

  public static String convertFahrenheitToCelcius(String temp){
      int tempF = Integer.parseInt(temp);
      tempF = tempF*5;
      tempF = tempF/9;
      return String.valueOf(tempF);
  }
}
