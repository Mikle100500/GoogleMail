package com.google.mail.pages;

import com.google.mail.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.google.mail.core.CustomConditions.nthProxyElementHasText;
import static com.google.mail.core.CustomConditions.texts;

public class GmailPage extends BasePage {

    private final By elementsLocator = By.cssSelector("[role='main'] .zA");

    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGmail() {
        this.getDriver().get("https://gmail.com");
    }

    public void setLogin(String email, String password) {

        $("#Email").sendKeys(email, Keys.ENTER);
        $("#Passwd").sendKeys(password, Keys.ENTER);
    }

    public void send(String emailAddress, String subjectOfLetter) {

        $(byText("COMPOSE")).click();
        $("[name='to']").sendKeys(emailAddress);
        $("[name='subjectbox']").sendKeys(subjectOfLetter);
        $(byText("Send")).click();
    }

    public void search(String query) {
        $("[name='q']").clear();
        $("[name='q']").sendKeys(query + Keys.ENTER);
    }

    public void refresh() {
        $(".asf").click();
    }

    public void clickInbox() {
        $(byTitle("Inbox")).click();
    }

    public void clickSent() {
        $(byTitle("Sent Mail")).click();
    }

    public void assertEmail(int index, String subject) {
        assertThat(nthProxyElementHasText(elementsLocator, index, subject));
    }

    public void assertEmails(String... texts) {
        assertThat(texts(elementsLocator, texts));
    }
}
