package ru.depedence.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {

    private final SelenideElement loginBtn = $("#login-button");
    private final SelenideElement errorMsgContainer = $(".error-message-container");

    @Step("Open page")
    public LoginPage open() {
        open("/");
        return this;
    }

    @Step("Check logo is visible")
    public LoginPage logoIsVisible() {
        $(".login_logo").shouldBe(Condition.visible);
        return this;
    }

    @Step("Check login button is visible")
    public void loginBtnIsVisible() {
        loginBtn.shouldBe(Condition.visible);
    }

    @Step("Fill login inputs")
    public LoginPage fillInputs(String username, String password) {
        $("#user-name").setValue(username);
        $("#password").setValue(password);
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    @Step("Check error message")
    public void checkErrorMsg() {
        errorMsgContainer.shouldBe(Condition.visible);
    }

    public String getErrorMsg() {
        return errorMsgContainer.getText();
    }

}