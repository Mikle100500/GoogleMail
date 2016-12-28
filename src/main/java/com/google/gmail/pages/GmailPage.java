package com.google.gmail.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
    List<WebElement> emails;

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

    //  locator of first found letter
    @FindBy(css = ".srg .g:nth-child(1)")
    public WebElement firstResult;

    public void navigateToGmail() {
        driver.get("https://gmail.com");
    }

    public void setLogin(String email, String password) {
        loginEmail.sendKeys(email, Keys.ENTER);
        loginPassword.sendKeys(password, Keys.ENTER);
    }

    public void send(String emailAddress, String subjectOfLetter) {

        compose.click();
        to.sendKeys(emailAddress);
        subject.sendKeys(subjectOfLetter);
        send.click();
    }

    public void search(String query) {
        search.sendKeys(query + Keys.ENTER);
    }

    public void refresh() {
        refresh.click();
    }

    public void clickInbox() {
        inbox.click();
    }

    public void clickSent() {
        sent.click();
    }

    public void assertTrue(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(driver, 10)).until(condition);
    }

}
