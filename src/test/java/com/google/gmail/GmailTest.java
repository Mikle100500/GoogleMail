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

    private GmailPage gmailPage = new GmailPage();
    private String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());

    @Test
    public void testSendAndReceiveEmail() {
        gmailPage.navigateToGmail();
        gmailPage.login(emailAddress, password);
        gmailPage.sendNewLetter(emailAddress, subject);
        gmailPage.refresh();

        gmailPage.assertEmailIsIn(0, subject);

        gmailPage.clickSent();
        gmailPage.assertEmailIsIn(0, subject);

        gmailPage.clickInbox();
        gmailPage.assertOnlyOneExist(subject);

    }
}
