package ru.depedence.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.depedence.core.BaseUiTest;
import ru.depedence.data.TestData;
import ru.depedence.data.TestOrder;
import ru.depedence.pages.CartPage;
import ru.depedence.pages.InventoryPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InventoryUiTest extends BaseUiTest {

    @Test
    void checkTotalPriceProducts() {
        InventoryPage page = new InventoryPage().open();
        assertEquals(TestData.TOTAL_INVENTORY_PRICE, page.getTotalPrice());
    }

    @Test
    void userCanAddProductToTheCart() {
        InventoryPage page = new InventoryPage()
                .open()
                .clickAddToCartBtn();

        String cartBadgeCount = page.getCartBadge();
        assertEquals("1", cartBadgeCount);

        CartPage cartPage = page.clickCart();
        String cartContent = cartPage.getCartContent();
        assertTrue(cartContent.contains(TestData.PRODUCT_NAME));
        assertTrue(cartContent.contains(TestData.PRODUCT_PRICE));
    }

    @Test
    void userCanPlaceTheOrder() {
        TestOrder order = TestData.ORDER;

        CartPage page = new InventoryPage()
                .open()
                .clickAddToCartBtn()
                .clickCart()
                .clickCheckoutBtn()
                .fillOrderInputs(order.firstName(), order.lastName(), order.postalCode())
                .clickContinueBtn();

        assertTrue(page.getSummaryInfo().contains(TestData.ORDER_TOTAL_PRICE));

        page.finishOrder();
    }

}