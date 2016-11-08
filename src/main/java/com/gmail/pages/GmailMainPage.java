package com.gmail.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GmailMainPage {

    public void clickCompose() {
        $(byText("COMPOSE")).click();
    }

    public void setAdress(String email) {
        $(By.name("to")).setValue(email);
    }

    public void setSubject(String subject) {
        $(By.name("subjectbox")).setValue(subject);
    }

    public void send() {
        $(byText("Send")).click();
    }

    public void navigateToInbox() {
        open("https://mail.google.com/mail/#inbox");
    }

    public void navigateToSent() {
        open("https://mail.google.com/mail/#sent");
    }

    public void assertLetterIsIn(String subject) {
        $(byText(subject)).should(exist);
    }
}
