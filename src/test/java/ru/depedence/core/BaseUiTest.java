package ru.depedence.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseUiTest {

    protected String baseUrl;

    @BeforeAll
    void setupAll() {
        baseUrl = "https://www.saucedemo.com";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10_000;
        Configuration.baseUrl = baseUrl;
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}