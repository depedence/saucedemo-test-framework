package ru.depedence.pages;

import com.codeborne.selenide.Condition;

public class InventoryPage extends BasePage {

    public void checkPageOpened() {
        $("#react-burger-menu-btn").shouldBe(Condition.visible);
    }

}