package com.google.mail.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;

public class CustomConditions{

    public static ExpectedCondition<WebElement> nthProxyElementHasText(final List<WebElement> elements
            , final int index
            , final String expectedText) {

        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    return elements.get(index).getText().contains(expectedText)? elements.get(index):null;
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
                        , elements.get(index).getText());
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> texts(final List<WebElement> elements, final String... texts) {
        return new ExpectedCondition<List<WebElement>>(){

            final List<String> proxyTexts = new ArrayList<String>();
            final List<WebElement> returnedProxyElements = new ArrayList<WebElement>();

            public List<WebElement> apply(WebDriver webDriver) {

                for (WebElement proxyElement : elements) {
                    proxyTexts.add(proxyElement.getText());
                }

                for (int i = 0; i < proxyTexts.size(); i++) {
                    if (proxyTexts.get(i).contains(texts[i])) {
                        returnedProxyElements.add(elements.get(i));
                    }
                }

                return elements.size() == returnedProxyElements.size() ? returnedProxyElements : null;
            }

            public String toString(){
                // TODO: 03.01.2017
                return String.format("");
            }
        };
    }
}
