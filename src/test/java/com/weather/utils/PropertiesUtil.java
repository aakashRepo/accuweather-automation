package com.weather.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    static Properties prop;

    public static void loadProperties() {
        try {
            System.out.println("Loading Properties File");
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/data/EnvConfig.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        System.out.println("Get Value for: " + key);
        return prop.getProperty(key);
    }
}
