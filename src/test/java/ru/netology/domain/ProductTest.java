package ru.netology.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {
    Product product = new Product (1, "phone", 120);
    Product product1 = new Product (2, "book", 100);
    @Test
    void bookNameShouldMatch() {

        String searchString = "phone";
        assertTrue(product.matches(searchString));
    }
    @Test
    void bookAuthorShouldMatch() {
        String searchString = "book";
        assertTrue(product1.matches(searchString));
    }
    @Test
    void bookNameShouldNotMatch() {
        String searchString = "iPhone";
        assertFalse(product.matches(searchString));
    }
    @Test
    void bookAuthorShouldNotMatch() {
        String searchString = "TV";
        assertFalse(product1.matches(searchString));
    }

}