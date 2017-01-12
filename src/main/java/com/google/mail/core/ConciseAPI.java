package com.google.mail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(RemoteWebDriver setDriver){
        driver = setDriver;
    }


    public WebElement $(By locator) {
        return assertThat(visibilityOfElementLocated(locator));
    }

    public WebElement $(String cssSelector) {
        return assertThat(visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public By byText(String text) {
        return By.xpath(String.format("//*[contains(text(), '%s')]", text));
    }

    public By byTitle(String title) {
        return By.cssSelector(String.format("[title='%s']", title));
    }

    public <V> V assertThat(ExpectedCondition<V> condition, int timeout) {
        return (new WebDriverWait(driver, timeout)).until(condition);
    }

    public <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, Configuration.timeout);
    }
}
