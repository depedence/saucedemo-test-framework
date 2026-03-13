package ru.depedence.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class InventoryPage extends BasePage {

    private final SelenideElement menuBtn = $("#react-burger-menu-btn");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");

    public InventoryPage clickAddToCartBtn() {
        $("#add-to-cart-sauce-labs-backpack").click();
        return this;
    }

    public String getCartBadge() {
        cartBadge.shouldBe(Condition.visible);
        return cartBadge.getText();
    }

    public InventoryPage clickCart() {
        $(".shopping_cart_link").click();
        return this;
    }

    public String getCartContent() {
        return $(".cart_item").getText();
    }

    public InventoryPage open() {
        open("/inventory.html");
        return this;
    }

    public double getTotalPrice() {
        return $$(".inventory_item_price").stream()
                .mapToDouble(el -> Double.parseDouble(el.getText().replace("$", "")))
                .sum();
    }

    public void checkPageOpened() {
        menuBtn.shouldBe(Condition.visible);
    }

}