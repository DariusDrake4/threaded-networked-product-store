package uncle_d_golf_pro_shop.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import uncle_d_golf_pro_shop.models.SalableProduct;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParserServiceTest {

    @Mock
    IInventoryManager manager;

    @InjectMocks
    ParserService parser;

    @BeforeEach
    void setup() {
        parser = new ParserService(manager);
    }

    @Test
    void testAllCommand() {
        when(manager.getAllProducts()).thenReturn(Collections.emptyList());
        String result = parser.handle("ALL");
        assertTrue(result.contains("[]"));
    }

    @Test
    void testGetCommand() {
        SalableProduct product =
                new SalableProduct(1, "Ball", "Round ball", LocalDate.now(), 9.99);

        when(manager.getProductById(1)).thenReturn(product);

        String result = parser.handle("GET 1");
        assertTrue(result.contains("Ball"));
    }

    @Test
    void testFindCommand() {
        SalableProduct product =
                new SalableProduct(2, "Glove", "Leather glove", LocalDate.now(), 19.99);

        // FIX: return a LIST, not a single product
        when(manager.searchProductsByName("Glove"))
                .thenReturn(Collections.singletonList(product));

        String result = parser.handle("FIND Glove");
        assertTrue(result.contains("Glove"));
    }

    @Test
    void testDeleteCommand() {
        when(manager.removeProduct(3)).thenReturn(true);
        String result = parser.handle("DELETE 3");
        assertTrue(result.contains("Removed"));
    }

    @Test
    void testAddCommand() {
        when(manager.addProduct(any(SalableProduct.class))).thenReturn(true);

        String result =
                parser.handle("ADD 10 Glove Leather glove 2024-12-01 19.99");

        assertTrue(result.contains("Product added"));
    }
}
