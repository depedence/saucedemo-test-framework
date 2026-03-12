package ru.depedence.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

public abstract class BasePage {

    protected void open(String path) {
        Selenide.open(path);
    }

    protected SelenideElement $(String locator) {
        return Selenide.$(locator);
    }

    protected ElementsCollection $$(String locator) {
        return Selenide.$$(locator);
    }

    protected void waitForPageLoad() {
        Selenide.Wait().until(webDriver ->
                "complete".equals(
                        ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState")
                )
        );
    }

}