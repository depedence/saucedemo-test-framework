package ru.depedence.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
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
        Configuration.headless = true;
        Configuration.timeout = 10_000;
        Configuration.baseUrl = baseUrl;
    }

    @BeforeEach
    void setupSession() {
        Selenide.open("/");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        Selenide.localStorage().clear();

        Cookie sessionCookie = new Cookie.Builder("session-username", "standard_user")
                .domain("www.saucedemo.com")
                .path("/")
                .isHttpOnly(false)
                .isSecure(false)
                .sameSite("None")
                .build();

        WebDriverRunner.getWebDriver().manage().addCookie(sessionCookie);
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}