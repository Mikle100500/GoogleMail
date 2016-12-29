package com.google.mail.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.google.mail.core.ConciseAPI.$;
import static com.google.mail.core.ConciseAPI.$$;

public class GmailPage {

    private WebDriver driver;

    public GmailPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //    Credentials: email for logging in, password
    @FindBy(css = "#Email")
    WebElement loginEmail;

    @FindBy(css = "#Passwd")
    WebElement loginPassword;

    //    Emails on the page
    @FindBy(css = "[role='main'] .zA")
    public List<WebElement> emails;

    //    Compose, filling and sending a letter
    @FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
    WebElement compose;

    @FindBy(name = "to")
    WebElement to;

    @FindBy(name = "subjectbox")
    WebElement subject;

    @FindBy(xpath = "//div[contains(text(), 'Send')]")
    WebElement send;

    //  search needed letter using search field
    @FindBy(name = "q")
    WebElement search;

    //  refresh the page
    @FindBy(xpath = "//div[contains(@class, 'asf')]")
    WebElement refresh;

    //  location of "Inbox" button
    @FindBy(css = "[title~='Inbox']")
    WebElement inbox;

    //  location of "Sent" button
    @FindBy(linkText = "Sent Mail")
    WebElement sent;

    public void navigateToGmail() {
        driver.get("https://gmail.com");
    }

    public void setLogin(String email, String password) {

        $(driver, loginEmail).sendKeys(email, Keys.ENTER);
        $(driver, loginPassword).sendKeys(password, Keys.ENTER);
    }

    public void send(String emailAddress, String subjectOfLetter) {

        $(driver, compose).click();
        $(driver, to).sendKeys(emailAddress);
        subject.sendKeys(subjectOfLetter);
        send.click();
    }

    public void search(String query) {
        $(driver, search).sendKeys(query + Keys.ENTER);
    }

    public void refresh() {
        $(driver, refresh).click();
    }

    public void clickInbox() {
        $(driver, inbox).click();
    }

    public void clickSent() {
        $(driver, sent).click();
    }

}
