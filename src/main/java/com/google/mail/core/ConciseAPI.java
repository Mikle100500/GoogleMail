package com.google.mail.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ConciseAPI {

    public static WebElement $(WebDriver driver, WebElement proxyElement) {

        return (new WebDriverWait(driver, Configuration.timeout))
                .until(ExpectedConditions
                        .visibilityOf(proxyElement));
    }

    public static List<WebElement> $$(WebDriver driver, List<WebElement> proxyElements) {

        return (new WebDriverWait(driver, Configuration.timeout))
                .until(ExpectedConditions
                        .visibilityOfAllElements(proxyElements));
    }

    public static void assertThat(WebDriver driver, int timeout, ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(driver, timeout)).until(condition);
    }

    public static void assertThat(WebDriver driver, ExpectedCondition<Boolean> condition) {
        assertThat(driver, Configuration.timeout, condition);
    }

}
