package ru.netology.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class BookTest {
    Book book = new Book(1, "Название1", 100, "Автор1");
    @Test
    void bookNameShouldMatch() {
        String searchString = "Название1";
        assertTrue(book.matches(searchString));
    }
    @Test
    void bookAuthorShouldMatch() {
        String searchString = "Автор1";
        assertTrue(book.matches(searchString));
    }
    @Test
    void bookNameShouldNotMatch() {
        String searchString = "Название2";
        assertFalse(book.matches(searchString));
    }
    @Test
    void bookAuthorShouldNotMatch() {
        String searchString = "Автор3";
        assertFalse(book.matches(searchString));
    }
}