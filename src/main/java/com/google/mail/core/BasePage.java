package com.google.mail.core;

import org.openqa.selenium.WebDriver;

public class BasePage extends ConciseAPI {

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
