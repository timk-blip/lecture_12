package ru.netology.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartphoneTest {

    Smartphone smartphone = new Smartphone( 4, "NOVA", 130, "NOVA+");
    @Test
    void bookNameShouldMatch() {
        String searchString = "NOVA";
        assertTrue(smartphone.matches(searchString));
    }
    @Test
    void bookAuthorShouldMatch() {
        String searchString = "NOVA+";
        assertTrue(smartphone.matches(searchString));
    }
    @Test
    void bookNameShouldNotMatch() {
        String searchString = "COLA";
        assertFalse(smartphone.matches(searchString));
    }
    @Test
    void bookAuthorShouldNotMatch() {
        String searchString = "COLA+";
        assertFalse(smartphone.matches(searchString));
    }
}