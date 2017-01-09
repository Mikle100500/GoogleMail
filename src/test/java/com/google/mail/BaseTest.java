package com.google.mail;

import com.google.mail.core.ConciseAPI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends ConciseAPI{

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
