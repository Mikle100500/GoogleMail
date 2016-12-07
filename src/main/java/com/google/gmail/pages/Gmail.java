package com.google.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Gmail extends BasePage{

    public static void navigateToGmail() {
        driver.get("https://gmail.com");
    }

    public static void login(String email, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Email")))
                .sendKeys(email + Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Passwd")))
                .sendKeys(password + Keys.ENTER);
    }
}
