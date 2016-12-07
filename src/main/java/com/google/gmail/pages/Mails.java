package com.google.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Mails extends BasePage {

    public static List<WebElement> emails = wait.until(ExpectedConditions
            .presenceOfAllElementsLocatedBy(By.cssSelector("[role='main'] .zA")));

    public static void send(String email, String subject) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]"))).click();
        driver.findElement(By.name("to")).sendKeys(email);
        driver.findElement(By.name("subjectbox")).sendKeys(subject);
        driver.findElement(By.xpath("//div[contains(text(), 'Send')]")).click();
    }

    public static void search(String query) {

        driver.findElement(By.name("q")).sendKeys(query + Keys.ENTER);
    }

//    public static void assertEmail(int index, String emailHeaderText) {
//        emails.get(index).shouldHave(text(emailHeaderText));
//    }
//
//    public static void assertEmails(String... emailHeaderTexts) {
//        emails.shouldHave(texts(emailHeaderTexts));
//    }
}
