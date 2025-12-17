package uncle_d_golf_pro_shop.services;

import uncle_d_golf_pro_shop.models.SalableProduct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class manages the list of products in the inventory.
 * It lets us add, remove, update, search, and sort products.
 */
public class InventoryManager implements IInventoryManager {

    private final List<SalableProduct> inventory = new ArrayList<>();

    /**
     * Creates a new inventory manager and loads some starter items.
     */
    public InventoryManager() {
        seedData();
    }

    private void seedData() {
        inventory.add(new SalableProduct(1, "Ball", "Golf ball", LocalDate.now(), 4.99));
        inventory.add(new SalableProduct(2, "Club", "Driver club", LocalDate.now(), 199.99));
        inventory.add(new SalableProduct(3, "Glove", "Leather glove", LocalDate.now(), 14.99));
    }

    /**
     * Gets a product by its ID.
     * @param id the product id
     * @return the product or null if not found
     */
    @Override
    public SalableProduct getProductById(int id) {
        return inventory.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Adds a product to the inventory.
     * @param product the item to add
     * @return true if it was added, false if the id already exists
     */
    @Override
    public boolean addProduct(SalableProduct product) {
        if (getProductById(product.getId()) != null) return false;
        inventory.add(product);
        return true;
    }

    /**
     * Removes a product using its ID.
     * @param id the id to remove
     * @return true if the item was removed
     */
    @Override
    public boolean removeProduct(int id) {
        return inventory.removeIf(p -> p.getId() == id);
    }

    /**
     * Updates a product that already exists.
     * @param updated the product with new values
     * @return true if the update worked
     */
    @Override
    public boolean updateProduct(SalableProduct updated) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId() == updated.getId()) {
                inventory.set(i, updated);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets all products in the inventory.
     * @return a list of all products
     */
    @Override
    public List<SalableProduct> getAllProducts() {
        return new ArrayList<>(inventory);
    }

    /**
     * Searches for products by name.
     * @param name part of the name to look for
     * @return a list of matching products
     */
    @Override
    public List<SalableProduct> searchProductsByName(String name) {
        return inventory.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Searches for products by description.
     * @param description part of the description to look for
     * @return a list of matching products
     */
    @Override
    public List<SalableProduct> searchProductsByDescription(String description) {
        return inventory.stream()
                .filter(p -> p.getDescription().toLowerCase().contains(description.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Sorts products by price from low to high.
     * @return a sorted list
     */
    @Override
    public List<SalableProduct> sortByPriceAscending() {
        return inventory.stream()
                .sorted(Comparator.comparingDouble(SalableProduct::getPrice))
                .collect(Collectors.toList());
    }

    /**
     * Sorts products by price from high to low.
     * @return a sorted list
     */
    @Override
    public List<SalableProduct> sortByPriceDescending() {
        return inventory.stream()
                .sorted(Comparator.comparingDouble(SalableProduct::getPrice).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Returns the actual inventory list.
     * @return the inventory
     */
    @Override
    public List<SalableProduct> getInventory() {
        return inventory;
    }
}
