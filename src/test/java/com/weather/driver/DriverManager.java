package com.weather.driver;

import com.weather.constants.TestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getWebDriver(String browser) {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
