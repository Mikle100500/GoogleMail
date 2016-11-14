package com.google.gmail.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;


public class GmailPage {

    public ElementsCollection emails = $$("[role='main'] .zA");

    public void navigateToGmail() {
        open("https://gmail.com");
    }

    public void login(String email, String pass) {
        $("#Email").setValue(email).submit();
        $("#Passwd").setValue(pass).submit();
    }

    public void send(String address, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(address);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();

    }

    public void refresh() {
        $(byTitle("Refresh")).click();
    }

    public void clickInbox() {
        $("[title~='Inbox']").click();
    }

    public void clickSent() {
        $(byTitle("Sent Mail")).click();
    }

    public void search(String subject){
        $(By.name("q")).setValue(subject).pressEnter();
    }

    public void assertEmail(int index, String subject) {
        emails.get(index).shouldHave(text(subject));
    }

    public void assertIsFirst(int index, String subject) {
        emails.get(index).$(".y6").shouldHave(exactText(subject));
    }

}
