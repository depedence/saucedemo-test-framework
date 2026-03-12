package ru.depedence.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.depedence.core.BaseUiTest;
import ru.depedence.data.TestData;
import ru.depedence.data.TestUser;
import ru.depedence.pages.InventoryPage;
import ru.depedence.pages.LoginPage;

@Epic("Swag Labs")
@Feature("Login")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @Test
    @Story("Invalid login")
    @DisplayName("User can't login to app with invalid credentials")
    void userCantLogin_Invalid() {
        TestUser user = TestData.INVALID;

        new LoginPage()
                .open()
                .fillInputs(user.username(), user.password())
                .clickLoginBtn()
                .checkErrorMsg();
    }

}