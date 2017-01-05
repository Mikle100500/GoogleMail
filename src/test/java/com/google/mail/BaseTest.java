package com.google.mail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
