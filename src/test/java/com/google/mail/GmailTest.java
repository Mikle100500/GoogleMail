package com.google.mail;

import com.google.mail.pages.GmailPage;
import org.junit.Test;

import java.util.Calendar;

import static com.google.mail.core.ConciseAPI.$$;
import static com.google.mail.core.ConciseAPI.assertThat;
import static com.google.mail.testdata.Config.emailAddress;
import static com.google.mail.testdata.Config.password;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class GmailTest extends BaseTest {

    private GmailPage page = new GmailPage(driver);

    @Test
    public void testLoginSendReceiveSearch() {

        String subject = String.format("Test Letter: %s", Calendar.getInstance().getTime());

        page.navigateToGmail();
        page.setLogin(emailAddress, password);
        page.send(emailAddress, subject);
        page.refresh();
        assertThat(driver, textToBePresentInElement($$(driver, page.emails).get(0), subject));

        page.clickSent();
        assertThat(driver,textToBePresentInElement($$(driver, page.emails).get(0), subject));

        page.clickInbox();
        page.search(subject);
        assertThat(driver, textToBePresentInElement($$(driver, page.emails).get(0), subject));
    }
}
