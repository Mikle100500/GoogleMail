package com.google.gmail;

import com.codeborne.selenide.Configuration;
import com.google.gmail.pages.Gmail;
import com.google.gmail.pages.Mails;
import com.google.gmail.pages.Menu;
import org.junit.Test;

import java.util.Calendar;

import static com.google.gmail.testdata.Config.emailAddress;
import static com.google.gmail.testdata.Config.password;

public class GmailTest {

    {
        Configuration.timeout = 20000;
    }

    @Test
    public void testLoginSendReceiveSearch() {

        String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());

        Gmail.navigateToGmail();
        Gmail.login(emailAddress, password);
        Mails.send(emailAddress, subject);
        Menu.refresh();

        Mails.assertEmail(0, subject);

        Menu.clickSent();
        Mails.assertEmail(0, subject);

        Menu.clickInbox();
        Mails.search(subject);
        Mails.assertEmails(subject);
    }
}
