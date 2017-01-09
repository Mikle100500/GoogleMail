package com.google.mail.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class ConciseAPI {

    public abstract WebDriver getDriver();

    public WebElement getWebElement(By locator){
        return getDriver().findElement(locator);
    }

    public List<WebElement> getWebElements(By locator){
        return getDriver().findElements(locator);
    }

    public WebElement $(WebElement proxyElement) {
        return assertThat(visibilityOf(proxyElement));
    }

    public <V> V assertThat(ExpectedCondition<V> condition, int timeout) {
        return (new WebDriverWait(getDriver(), timeout)).until(condition);
    }

    public <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, Configuration.timeout);
    }
}
