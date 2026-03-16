package ru.depedence.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Cookie;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseUiTest {

    protected String baseUrl;

    @BeforeAll
    void setupAll() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        baseUrl = "https://www.saucedemo.com";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10_000;
        Configuration.baseUrl = baseUrl;
    }

    @BeforeEach
    void setupSession() {
        Selenide.open("https://www.saucedemo.com");

        Cookie sessionCookie = new Cookie.Builder("session-username", "standard_user")
                .domain("www.saucedemo.com")
                .path("/")
                .isHttpOnly(false)
                .isSecure(false)
                .sameSite("None")
                .build();

        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().manage().addCookie(sessionCookie);
        Selenide.localStorage().clear();
    }

    @AfterAll
    void tearDown() {
        Selenide.closeWebDriver();
    }

}