package com.google.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Mails extends BasePage {

    public static List<WebElement> emails(){
        return PageFactory.initElements(driver, BasePage.class).emails;
    }

    public static void send(String email, String subject) {

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")))
                .click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("to"))).sendKeys(email);
        driver.findElement(By.name("subjectbox")).sendKeys(subject);
        driver.findElement(By.xpath("//div[contains(text(), 'Send')]")).click();
    }

    public static void search(String query) {

        driver.findElement(By.name("q")).sendKeys(query + Keys.ENTER);

    }

    public static void assertEmail(int index, String emailHeaderText) {
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(emails().get(index), emailHeaderText)));
    }

//    public static void assertEmails(String... emailHeaderTexts) {
//
//        for (WebElement email : wait.until(ExpectedConditions.elements(emails()))) {
//            for (String mailText : emailHeaderTexts) {
//                assertTrue(email.getText().contains(mailText));
//            }
//        }
//    }
}
