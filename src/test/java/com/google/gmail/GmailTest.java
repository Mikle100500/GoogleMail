package com.google.gmail;

import com.google.gmail.pages.GmailPage;
import org.junit.Test;

import java.util.Calendar;

import static com.google.gmail.testdata.Config.emailAddress;
import static com.google.gmail.testdata.Config.password;
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
        page.assertTrue(textToBePresentInElement(page.firstResult, subject));

        page.clickSent();
        page.assertTrue(textToBePresentInElement(page.firstResult, subject));

        page.clickInbox();
        page.search(subject);
        page.assertTrue(textToBePresentInElement(page.firstResult, subject));
    }
}
