package com.google.mail.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.mail.core.Wrappers.elementExceptionsCatcher;

public class CustomConditions {

    public static ExpectedCondition<WebElement> nthElementHasText(final By locator, final int index
            , final String expectedText) {

        return elementExceptionsCatcher(new ExpectedCondition<WebElement>() {

            private WebElement element;
            private String actualText;

            public WebElement apply(WebDriver driver) {

                element = driver.findElements(locator).get(index);
                actualText = element.getText();
                return actualText.contains(expectedText) ? element : null;
            }

            public String toString() {
                return String.format("\nText of %s element,"
                                + "\nof the elements %s"
                                + "\nShould be: %s"
                                + "\nActual text is: %s\n"
                        , index
                        , element.toString()
                        , expectedText
                        , actualText);
            }
        });
    }

    public static ExpectedCondition<List<WebElement>> texts(final By locator, final String... texts) {
        return elementExceptionsCatcher(new ExpectedCondition<List<WebElement>>() {

            private List<String> actualTexts = new ArrayList<String>();
            private List<WebElement> elements;

            public List<WebElement> apply(WebDriver driver) {

                actualTexts.clear();
                elements = driver.findElements(locator);
                for (WebElement proxyElement : elements) {
                    actualTexts.add(proxyElement.getText());
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
