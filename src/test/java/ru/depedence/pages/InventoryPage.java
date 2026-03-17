package ru.depedence.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private final SelenideElement menuBtn = $("#react-burger-menu-btn");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");
    private final SelenideElement logoutBtn = $("#logout_sidebar_link");
    private final ElementsCollection itemName = $$(".inventory_item_name");
    private final ElementsCollection itemPrice = $$(".inventory_item_price");

    public InventoryPage clickToBackpack(String productName) {
        itemName.findBy(Condition.text(productName)).click();
        return this;
    }

    public String getProductText() {
        return $("[data-test='inventory-item-desc']").getText();
    }

    public InventoryPage clickBurgerMenu() {
        menuBtn.click();
        logoutBtn.shouldBe(Condition.visible);
        return this;
    }

    public LoginPage clickLogoutBtn() {
        logoutBtn.click();
        $(".login_credentials_wrap-inner").shouldBe(Condition.visible);
        return new LoginPage();
    }

    public InventoryPage selectSort(String option) {
        $(".product_sort_container").selectOption(option);
        return this;
    }

    public List<String> getItemNames() {
        return itemName.texts();
    }

    public List<Double> getItemPrices() {
        return itemPrice.texts().stream()
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
        return itemPrice.stream()
                .mapToDouble(el -> Double.parseDouble(el.getText().replace("$", "")))
                .sum();
    }

    public void checkPageOpened() {
        menuBtn.shouldBe(Condition.visible);
    }

}