package com.google.mail.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConciseAPI {

    public static WebElement $(WebDriver driver, WebElement proxyElement) {

        return (new WebDriverWait(driver, Configuration.timeout))
                .until(ExpectedConditions
                        .visibilityOf(proxyElement));
    }

    public static <T> T assertThat(WebDriver driver, ExpectedCondition<T> condition) {
        return (new WebDriverWait(driver, Configuration.timeout)).until(condition);
    }
}
