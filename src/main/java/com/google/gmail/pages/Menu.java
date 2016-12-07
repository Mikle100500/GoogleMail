package com.google.gmail.pages;

import org.openqa.selenium.By;

public class Menu extends BasePage{

    public static void refresh() {

        driver.findElement(By.cssSelector("[aria-label='Refresh']")).click();
    }

    public static void clickInbox() {

        driver.findElement(By.cssSelector("[title~='Inbox']")).click();
    }

    public static void clickSent() {

        driver.findElement(By.linkText("Sent Mail")).click();
    }
}
