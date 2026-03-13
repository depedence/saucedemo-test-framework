package ru.depedence.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.depedence.core.BaseUiTest;
import ru.depedence.pages.InventoryPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InventoryUiTest extends BaseUiTest {

    @Test
    void checkTotalPriceProducts() {
        double expectedTotalPrice = 129.94;
        InventoryPage page = new InventoryPage().open();
        assertEquals(expectedTotalPrice, page.getTotalPrice());
    }

    @Test
    void userCanAddProductToTheCart() {
        InventoryPage page = new InventoryPage()
                .open()
                .clickAddToCartBtn()
                .clickCart();

        String cartBadgeCount = page.getCartBadge();
        assertEquals("1", cartBadgeCount);

        String cartContent = page.getCartContent();
        assertTrue(cartContent.contains("Sauce Labs Backpack"));
        assertTrue(cartContent.contains("$29.99"));
    }

}