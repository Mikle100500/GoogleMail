package com.google.mail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.google.mail.core.ConciseAPI.getDriver;
import static com.google.mail.core.ConciseAPI.setDriver;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        setDriver(new FirefoxDriver());
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }
}
