package com.google.mail;

import com.google.mail.core.Configuration;
import com.google.mail.pages.GmailPage;
import org.junit.Test;

import java.util.Calendar;

import static com.google.mail.testdata.Config.emailAddress;
import static com.google.mail.testdata.Config.password;

public class GmailTest extends BaseTest {

    {
        Configuration.timeout = 10;
    }

    private GmailPage page = new GmailPage(getDriver());

    @Test
    public void testLoginSendReceiveSearch() {

        String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());

        page.navigateToGmail();
        page.setLogin(emailAddress, password);
        page.send(emailAddress, subject);
        page.refresh();
        page.assertEmail(0, subject);

        page.clickSent();
        page.assertEmail(0, subject);

        page.clickInbox();
        page.search(subject);
        page.assertEmails(subject);
    }
}
