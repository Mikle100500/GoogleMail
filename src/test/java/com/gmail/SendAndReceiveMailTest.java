package com.gmail;

import com.gmail.pages.GmailMainPage;
import com.gmail.pages.GoogleLogInPage;
import org.junit.Test;

import static com.gmail.config.Config.emailAddress;

public class SendAndReceiveMailTest {

    private GoogleLogInPage loginPage = new GoogleLogInPage();
    private GmailMainPage gmailPage = new GmailMainPage();

    @Test
    public void testLogin() {

        loginPage.navigateToGoogle();
        loginPage.clickSignIn();
        loginPage.setEmail();
        loginPage.setPassword();
    }

    @Test
    public void testSendEmail() {

        gmailPage.navigateToInbox();
        gmailPage.clickCompose();
        gmailPage.setAdress(emailAddress);
        gmailPage.setSubject("TestGmail");
        gmailPage.send();

        gmailPage.navigateToInbox();
        gmailPage.assertLetterIsIn("TestGmail");

        gmailPage.navigateToSent();
        gmailPage.assertLetterIsIn("TestGmail");

    }
}
