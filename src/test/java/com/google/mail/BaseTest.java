package com.google.mail;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    static WebDriver driver = new FirefoxDriver();

    @After
    public void tearDown() {
        driver.quit();
    }
}
