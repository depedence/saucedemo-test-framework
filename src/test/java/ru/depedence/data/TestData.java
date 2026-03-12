package ru.depedence.data;

public class TestData {
    public static final TestUser STANDARD =
            new TestUser("standard_user", "secret_sauce");

    public static final TestUser INVALID =
            new TestUser("invalidUser", "invalidPassword");

    public static final TestUser LOCKED =
            new TestUser("locked_out_user", "secret_sauce");
}