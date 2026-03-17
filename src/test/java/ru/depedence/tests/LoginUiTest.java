package ru.depedence.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.depedence.core.BaseUiTest;
import ru.depedence.data.TestData;
import ru.depedence.data.TestUser;
import ru.depedence.pages.InventoryPage;
import ru.depedence.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Swag Labs")
@Feature("Login")
public class LoginUiTest extends BaseUiTest {

    @Test
    @Story("Check logo on page")
    @DisplayName("Go to login page and check logo")
    void checkPage() {
        new LoginPage()
                .open()
                .logoIsVisible()
                .loginBtnIsVisible();
    }

    @Test
    @Story("Valid login")
    @DisplayName("User can login to app with valid credentials")
    void userCanLogin_Valid() {
        TestUser user = TestData.STANDARD;

        new LoginPage()
                .open()
                .fillInputs(user.username(), user.password())
                .clickLoginBtn();

        new InventoryPage()
                .checkPageOpened();
    }

    @ParameterizedTest
    @CsvSource({
            "invalid_user, wrong_password",
            ", some_password",
            "some_user, ",
            ", "
    })
    @Story("Invalid login")
    @DisplayName("User can't login to app with invalid credentials")
    void userCantLogin_Invalid(String username, String password) {
        new LoginPage()
                .open()
                .fillInputs(username, password)
                .clickLoginBtn()
                .checkErrorMsg();
    }

    @Test
    @Story("Check error message")
    @DisplayName("Check error message after invalid login")
    void checkErrorMessage() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        TestUser user = TestData.LOCKED;

        LoginPage page = new LoginPage()
                .open()
                .fillInputs(user.username(), user.password())
                .clickLoginBtn();

        String errorMsg = page.getErrorMsg();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMsg);
    }

}