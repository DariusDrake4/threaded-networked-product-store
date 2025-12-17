package uncle_d_golf_pro_shop.services;

import uncle_d_golf_pro_shop.models.SalableProduct;
import java.util.List;

public interface IInventoryManager {

    SalableProduct getProductById(int id);

    boolean addProduct(SalableProduct product);

    boolean removeProduct(int id);

    boolean updateProduct(SalableProduct product);

    List<SalableProduct> getAllProducts();

    List<SalableProduct> searchProductsByName(String name);

    List<SalableProduct> searchProductsByDescription(String description);

    List<SalableProduct> sortByPriceAscending();

    List<SalableProduct> sortByPriceDescending();

    List<SalableProduct> getInventory();
}
