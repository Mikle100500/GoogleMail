package com.google.gmail.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class GmailPage {

    public ElementsCollection emails = $$("tbody .zA");

    public void navigateToGmail() {
        open("https://gmail.com");
    }

    public void login(String email, String pass) {
        $("#Email").setValue(email).submit();
        $("#Passwd").setValue(pass).submit();
    }

    public void sendNewLetter(String address, String subject){
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(address);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();

    }

    public void refresh(){
        $("[title='Refresh']").click();
    }

    public void clickInbox(){
        $("[title~='Inbox']").click();
    }

    public void clickSent(){
        $(byText("Sent Mail")).click();
    }

    public void assertEmailIsIn(int index, String subject){
        emails.get(index).shouldHave(text(subject));
    }

    public void assertOnlyOneExist(String subject){
        emails.
    }

}
