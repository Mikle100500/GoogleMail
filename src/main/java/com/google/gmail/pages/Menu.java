package com.google.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Menu extends BasePage{

    public static void refresh() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Refresh']")))
                .click();
    }

    public static void clickInbox() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title~='Inbox']"))).click();
    }

    public static void clickSent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sent Mail"))).click();
    }
}
