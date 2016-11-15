package com.google.gmail.pages;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class Menu {

    public static void refresh() {
        $(byTitle("Refresh")).click();
    }

    public static void clickInbox() {
        $("[title~='Inbox']").click();
    }

    public static void clickSent() {
        $(byTitle("Sent Mail")).click();
    }
}
