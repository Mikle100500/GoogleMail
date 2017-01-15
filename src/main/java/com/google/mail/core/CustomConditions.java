package com.google.mail.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.mail.core.Wrappers.elementExceptionsCatcher;

public class CustomConditions {

    private static String actualText;

    public static ExpectedCondition<WebElement> nthProxyElementHasText(final List<WebElement> elements
            , final int index
            , final String expectedText) {

        return elementExceptionsCatcher(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {

                WebElement element = elements.get(index);
                actualText = element.getText();
                return actualText.contains(expectedText) ? element : null;
            }

            public String toString() {
                return String.format("\nText of %s element,"
                                + "\nof the elements %s"
                                + "\nShould be: %s"
                                + "\nActual text is: %s\n"
                        , index
                        , elements.toString()
                        , expectedText
                        , actualText);
            }
        });
    }

    public static ExpectedCondition<List<WebElement>> texts(final List<WebElement> elements, final String... texts) {
        return elementExceptionsCatcher(new ExpectedCondition<List<WebElement>>() {

            List<String> actualTexts = new ArrayList<String>();

            public List<WebElement> apply(WebDriver webDriver) {

                actualTexts.clear();

                for (WebElement element : elements) {
                    actualTexts.add(element.getText());
                }

                if (actualTexts.size() != texts.length) {
                    return null;
                }

                for (int i = 0; i < actualTexts.size(); i++) {
                    if (!actualTexts.get(i).contains(texts[i])) {
                        return null;
                    }
                }
                return elements;
            }

            public String toString() {
                return String.format("\nTexts of list elements %s"
                                + "\nshould contain: %s"
                                + "\nwhile actual texts: %s\n"
                        , elements.toString()
                        , Arrays.toString(texts)
                        , actualTexts);
            }
        });
    }
}
