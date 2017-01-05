package com.google.mail.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ConciseAPI {

    public static WebElement $(WebDriver driver, WebElement proxyElement) {
        return assertThat(driver, visibilityOf(proxyElement));
    }

    public static <V> V assertThat(WebDriver driver, ExpectedCondition<V> condition, int timeout) {
        return (new WebDriverWait(driver, timeout)).until(condition);
    }

    public static <V> V assertThat(WebDriver driver, ExpectedCondition<V> condition) {
        return (new WebDriverWait(driver, Configuration.timeout)).until(condition);
    }
}