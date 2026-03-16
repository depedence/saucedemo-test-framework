package ru.depedence.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.depedence.core.BaseUiTest;
import ru.depedence.pages.InventoryPage;

public class LogoutUiTest extends BaseUiTest {

    private InventoryPage page;

    @BeforeEach
    void openInventory() {
        page = new InventoryPage().open();
    }

    @Test
    void userCanLogout() {
        page.clickBurgerMenu().clickLogoutBtn().logoIsVisible();
    }

}