package ru.depedence.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private final SelenideElement menuBtn = $("#react-burger-menu-btn");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");

    public InventoryPage selectSort(String option) {
        $(".product_sort_container").selectOption(option);
        return this;
    }

    public List<String> getItemNames() {
        return $$(".inventory_item_name").texts();
    }

    public List<Double> getItemPrices() {
        return $$(".inventory_item_price").texts().stream()
                .map(p -> Double.parseDouble(p.replace("$", "")))
                .collect(Collectors.toList());
    }

    public InventoryPage clickAddToCartBtn() {
        $("#add-to-cart-sauce-labs-backpack").click();
        return this;
    }

    public String getCartBadge() {
        cartBadge.shouldBe(Condition.visible);
        return cartBadge.getText();
    }

    public CartPage clickCart() {
        $(".shopping_cart_link").click();
        return new CartPage();
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