package com.google.gmail.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Gmail {

    public static void navigateToGmail() {
        open("https://gmail.com");
    }

    public static void login(String email, String password) {
        $("#Email").setValue(email).submit();
        $("#Passwd").setValue(password).submit();
    }
}
