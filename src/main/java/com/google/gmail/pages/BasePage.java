package com.google.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver = new FirefoxDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, 25);
}
