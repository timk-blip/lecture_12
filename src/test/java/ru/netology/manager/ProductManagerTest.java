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
    private Product book1 = new Book(2, "Dracula", 2000, "King");
    private Book book2 = new Book(3, "Malefisenta", 3000, "Kto-to");
    private Product smartphone1 = new Smartphone(4, "Iphone", 4000, "Tim Kuk");
    private Smartphone smartphone2 = new Smartphone(5, "Samsung", 5000, "Li Ben Chkhol");

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
        String text = "Dracula";

        Product[] expected = {book1};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookAuthor() {
        String text = "Kto-to";

        Product[] expected = {book2};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        String text = "Iphone";

        Product[] expected = {smartphone1};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturer() {
        String text = "Li Ben Chkhol";

        Product[] expected = {smartphone2};
        Product[] actual = ProductManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }
}