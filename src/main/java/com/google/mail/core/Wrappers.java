package com.google.mail.core;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.google.common.base.Function;

public class Wrappers {
    public static <V> ExpectedCondition<V> elementExceptionsCatcher(final Function<? super WebDriver, V> condition){
        return new ExpectedCondition<V>() {
            
            public V apply(WebDriver input) {
                try {
                    return condition.apply(input);
                } catch (StaleElementReferenceException e) {
                    return null;
                } catch (ElementNotVisibleException e){
                    return null;
                } catch (IndexOutOfBoundsException e){
                    return null;
                }
            }

            public String toString(){
                return condition.toString();
            }
        };
    }
}
