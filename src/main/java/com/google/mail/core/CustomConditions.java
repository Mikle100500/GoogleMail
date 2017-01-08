package com.google.mail.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomConditions {

    private static String actualText;

    public static ExpectedCondition<WebElement> nthProxyElementHasText(final List<WebElement> elements
            , final int index
            , final String expectedText) {

        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    actualText = elements.get(index).getText();
                    return actualText.contains(expectedText) ? elements.get(index) : null;
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\nText of %s element:"
                                + "\nExpected text should be: %s"
                                + "\nActual text is: %s\n"
                        , index
                        , expectedText
                        , actualText);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> texts(final List<WebElement> elements, final String... texts) {
        return new ExpectedCondition<List<WebElement>>() {

            List<String> actualTexts = new ArrayList<String>();

            public List<WebElement> apply(WebDriver webDriver) {

                actualTexts.clear();

                for (WebElement proxyElement : elements) {
                    actualTexts.add(proxyElement.getText());
                }

                if (actualTexts.size() != texts.length) {
                    return null;
                } else {
                    for (int i = 0; i < actualTexts.size(); i++) {
                        if (!actualTexts.get(i).contains(texts[i])) {
                            return null;
                        }
                    }
                    return elements;
                }
            }

            public String toString() {
                return String.format("\nTexts of list elements %s"
                                + "\nshould contain: %s"
                                + "\nwhile actual texts: %s\n"
                        , elements.toString()
                        , Arrays.toString(texts)
                        , actualTexts);
            }
        };
    }
}
