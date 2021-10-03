package com.weather.utils;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class PropertiesUtil {

    static Properties prop;

    public static void loadProperties() {
        try {
            log.info("Loading Properties File");
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/data/EnvConfig.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        log.info("Get Value for: " + key);
        return prop.getProperty(key);
    }
}
