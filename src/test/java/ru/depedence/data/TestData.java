package ru.depedence.data;

public class TestData {
    public static final TestUser STANDARD =
            new TestUser("standard_user", "secret_sauce");

    public static final TestUser LOCKED =
            new TestUser("locked_out_user", "secret_sauce");

    public static final TestOrder ORDER =
            new TestOrder("test", "name", "postalCodeTest");

    public static final double TOTAL_INVENTORY_PRICE = 129.94;
    public static final String ORDER_TOTAL_PRICE = "Total: $32.39";
    public static final String PRODUCT_NAME = "Sauce Labs Backpack";
    public static final String PRODUCT_PRICE = "$29.99";
    public static final String PRODUCT_ABOUT = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

}