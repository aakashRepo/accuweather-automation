package com.weather.tests;

import com.weather.driver.DriverManager;
import com.weather.pages.HomePage;
import com.weather.utils.CommonFunctions;
import com.weather.utils.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    public static WebDriverManager webDriverManager;
    public static WebDriver driver;
    HomePage homePage;


    @BeforeTest
    @Parameters({"browser"})
    public void launchDriver(String browser) {
        PropertiesUtil.loadProperties();
        driver = DriverManager.getWebDriver(browser);
        driver.get(PropertiesUtil.getProperty("url"));
        homePage = new HomePage(driver);
        homePage.acceptCookie();
    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }

}
