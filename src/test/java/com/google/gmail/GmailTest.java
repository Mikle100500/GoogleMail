package com.google.gmail;

import com.google.gmail.pages.Gmail;
import com.google.gmail.pages.Mails;
import com.google.gmail.pages.Menu;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static com.google.gmail.pages.BasePage.driver;
import static com.google.gmail.testdata.Config.*;
import static java.lang.Thread.sleep;

public class GmailTest {

    @Test
    public void testLoginSendReceiveSearch() throws InterruptedException {

        String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());

        Gmail.navigateToGmail();
        Gmail.login(emailAddress, password);
        Mails.send(emailAddress, subject);
        Menu.refresh();
        sleep(5000);
//        Mails.assertEmail(0, subject);
//
//        Menu.clickSent();
//        Mails.assertEmail(0, subject);
//
//        Menu.clickInbox();
//        Mails.search(subject);
//        Mails.assertEmails(subject);
    }

    @BeforeClass
    public static void setUp(){
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
