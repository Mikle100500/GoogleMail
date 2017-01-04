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

public class GmailTest {

    private GmailPage page = new GmailPage(driver);

    private static WebDriver driver = new FirefoxDriver();

    @Test
    public void testLoginSendReceiveSearch() {

        String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());

        page.navigateToGmail();
        page.setLogin(emailAddress, password);
        page.send(emailAddress, subject);
        page.refresh();
        assertThat(driver, nthProxyElementHasText(page.emails, 0, subject));

        page.clickSent();
        assertThat(driver, nthProxyElementHasText(page.emails, 0, subject));

        page.clickInbox();
        page.search(subject);
        assertThat(driver, texts(page.emails, subject));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
