package com.gmail.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.gmail.config.Config.emailAddress;
import static com.gmail.config.Config.password;


public class GoogleLogInPage {

    public void navigateToGoogle() {
        open("https://www.google.com/?hl=en");
    }

    public void clickSignIn() {
        $("#gb_70").click();
    }

    public void setEmail() {
        $("#Email").setValue(emailAddress).submit();
    }

    public void setPassword() {
        $("#Passwd").setValue(password).submit();
    }
}
