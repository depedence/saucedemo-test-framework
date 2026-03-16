package ru.depedence.pages;

import com.codeborne.selenide.Condition;

public class CartPage extends BasePage {

    public String getCartContent() {
        return $(".cart_item").getText();
    }

    public CartPage clickCheckoutBtn() {
        $(".checkout_button").click();
        return this;
    }

    public CartPage fillOrderInputs(String firstName, String lastName, String postalCode) {
        $("[data-test='firstName']").setValue(firstName);
        $("[data-test='lastName']").setValue(lastName);
        $("[data-test='postalCode']").setValue(postalCode);
        return this;
    }

    public CartPage clickContinueBtn() {
        $("[data-test='continue']").click();
        return this;
    }

    public String getSummaryInfo() {
        return $(".summary_info").getText();
    }

    public void finishOrder() {
        $("[data-test='finish']").click();
        $(".checkout_complete_container").shouldBe(Condition.visible);
    }

}