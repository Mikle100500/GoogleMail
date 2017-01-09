package com.google.mail.pages;

import com.google.mail.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.google.mail.core.CustomConditions.nthProxyElementHasText;
import static com.google.mail.core.CustomConditions.texts;

public class GmailPage extends BasePage{

    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGmail() {
        this.getDriver().get("https://gmail.com");
    }

    public void setLogin(String email, String password) {

        $(getWebElement(By.cssSelector("#Email"))).sendKeys(email, Keys.ENTER);
        $(getWebElement(By.cssSelector("#Passwd"))).sendKeys(password, Keys.ENTER);
    }

    public void send(String emailAddress, String subjectOfLetter) {

        $(getWebElement(By.xpath("//div[contains(text(),'COMPOSE')]"))).click();
        $(getWebElement(By.name("to"))).sendKeys(emailAddress);
        $(getWebElement(By.name("subjectbox"))).sendKeys(subjectOfLetter);
        $(getWebElement(By.xpath("//div[contains(text(), 'Send')]"))).click();
    }

    public void search(String query) {
        $(getWebElement(By.name("q"))).clear();
        $(getWebElement(By.name("q"))).sendKeys(query + Keys.ENTER);
    }

    public void refresh() {
        $(getWebElement(By.xpath("//div[contains(@class, 'asf')]"))).click();
    }

    public void clickInbox() {
        $(getWebElement(By.cssSelector("[title~='Inbox']"))).click();
    }

    public void clickSent() {
        $(getWebElement(By.linkText("Sent Mail"))).click();
    }

    public void assertEmail(int index, String subject) {
        assertThat(nthProxyElementHasText(getWebElements(By.cssSelector("[role='main'] .zA")), index, subject));
    }

    public void assertEmails(String... texts) {
        assertThat(texts(getWebElements(By.cssSelector("[role='main'] .zA")), texts));
    }

}
