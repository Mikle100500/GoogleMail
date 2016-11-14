package com.google.gmail;

import com.codeborne.selenide.Configuration;
import com.google.gmail.pages.GmailPage;
import org.junit.Test;

import java.util.Calendar;

import static com.google.gmail.testdata.Config.emailAddress;
import static com.google.gmail.testdata.Config.password;

public class GmailTest {

    {
        Configuration.timeout = 20000;
    }

    private GmailPage page = new GmailPage();

    @Test
    public void testLoginSendReceiveSearch() {

        String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());

        page.navigateToGmail();
        page.login(emailAddress, password);
        page.send(emailAddress, subject);
        page.refresh();

        page.assertEmail(0, subject);

        page.clickSent();
        page.assertEmail(0, subject);

        page.clickInbox();
        page.search(subject);
        page.assertIsFirst(0, subject);
    }
}
