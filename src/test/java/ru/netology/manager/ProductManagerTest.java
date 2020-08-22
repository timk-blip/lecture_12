package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product product1 = new Product(1, "Product 1", 1000);
    private Product book1 = new Book(2, "Book 1", 2000, "author 2");
    private Book book2 = new Book(3, "Book 2", 3000, "author 3");
    private Product smartphone1 = new Smartphone(4, "Phone 1", 4000, "manufacture 1");
    private Smartphone smartphone2 = new Smartphone(5, "Phone 2", 5000, "manufacture 2");

    @BeforeEach
    public void setUp(){
        manager.add(product1);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldSearchIfTextEmpty() {
        String text = "";

        Product[] expected = {};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        String text = "Book 1";

        Product[] expected = {book1};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookAuthor() {
        String text = "author 3";

        Product[] expected = {book2};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        String text = "Phone 1";

        Product[] expected = {smartphone1};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturer() {
        String text = "manufacture 2";

        Product[] expected = {smartphone2};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }
}
