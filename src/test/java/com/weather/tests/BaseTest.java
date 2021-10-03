package com.weather.tests;

import com.weather.driver.DriverManager;
import com.weather.utils.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    public static WebDriverManager webDriverManager;
    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void launchDriver(String browser) {
        PropertiesUtil.loadProperties();
        driver = DriverManager.getWebDriver(browser);
        driver.get(PropertiesUtil.getProperty("url"));
    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }

}
