package ru.depedence.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.depedence.core.BaseUiTest;
import ru.depedence.pages.InventoryPage;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortUiTest extends BaseUiTest {

    private InventoryPage page;

    @BeforeEach
    void openInventory() {
        page = new InventoryPage().open();
    }

    @Test
    void sortByNameAtoZ() {
        List<String> names = page.selectSort("Name (A to Z)").getItemNames();
        List<String> sorted = names.stream().sorted().toList();
        assertEquals(names, sorted);
    }

    @Test
    void sortByNameZtoA() {
        List<String> names = page.selectSort("Name (Z to A)").getItemNames();
        List<String> sorted = names.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        assertEquals(names, sorted);
    }

    @Test
    void sortByPriceLowToHigh() {
        List<Double> prices = page.selectSort("Price (low to high)").getItemPrices();
        List<Double> sorted = prices.stream().sorted().toList();
        assertEquals(prices, sorted);
    }

    @Test
    void sortByPriceHighToLow() {
        List<Double> prices = page.selectSort("Price (high to low)").getItemPrices();
        List<Double> sorted = prices.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        assertEquals(prices, sorted);
    }

}