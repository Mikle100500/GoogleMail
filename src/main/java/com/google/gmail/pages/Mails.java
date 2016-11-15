package com.google.gmail.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Mails {

    public static ElementsCollection emails = $$("[role='main'] .zA");

    public static void send(String email, String subject) {

        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(email);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public static void search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
    }

    public static void assertEmail(int index, String emailHeaderText) {
        emails.get(index).shouldHave(text(emailHeaderText));
    }

    public static void assertEmails(String... emailHeaderTexts) {
        emails.shouldHave(texts(emailHeaderTexts));
    }
}
