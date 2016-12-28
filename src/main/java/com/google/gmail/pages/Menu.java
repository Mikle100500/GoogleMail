package com.google.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Menu extends BasePage{

    public static void refresh() {

        WebElement refresh = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'asf')]")));
        refresh.click();
    }

    public static void clickInbox() {
        WebElement inbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title~='Inbox']")));
        inbox.click();
        wait.until(ExpectedConditions.attributeToBe(inbox, "tabindex", "0"));
    }

    public static void clickSent() {
        WebElement sent = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sent Mail")));
        sent.click();
        wait.until(ExpectedConditions.attributeToBe(sent, "tabindex", "0"));
    }
}
