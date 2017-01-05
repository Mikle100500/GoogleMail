package com.google.mail;

import com.google.mail.pages.GmailPage;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;

import static com.google.mail.core.ConciseAPI.assertThat;
import static com.google.mail.core.CustomConditions.nthProxyElementHasText;
import static com.google.mail.core.CustomConditions.texts;
import static com.google.mail.testdata.Config.emailAddress;
import static com.google.mail.testdata.Config.password;

public class GmailTest extends BaseTest {

    private GmailPage page = new GmailPage(driver);

    @Test
    public void testLoginSendReceiveSearch() {

        String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());
        String subject2 = "Test Letter: ggggggggggggggggggggggggggggg";
        String subject3 = "Test Letter: hhhhhhhhhhhhhhhhhhhhhhhhhhhhh";

        page.navigateToGmail();
        page.setLogin(emailAddress, password);
        page.send(emailAddress, subject);
        page.refresh();
        page.assertEmail(0, subject);

        page.clickSent();
        page.assertEmail(0, subject);

        page.clickInbox();
        page.search(subject);
        page.assertEmails(subject, subject2, subject3);
    }
}
