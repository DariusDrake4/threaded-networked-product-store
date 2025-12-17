package uncle_d_golf_pro_shop.models;

import java.time.LocalDate;

/**
 * SalableProduct represents a single product that can be stored in the
 * inventory. Each product has an id, description, name, manufacture date,
 * and price.
 *
 */

public class SalableProduct {

    private int id;
    private String name;
    private String description;
    private LocalDate dateOfManufacture;
    private double price;

    /**
     * Creates a new SalableProduct with all fields set.
     *
     * @param id the product id.
     * @param name the product name.
     * @param description small description of the product.
     * @param dateOfManufacture the date the product was manufactured.
     * @param price  price of the product.
     *
     */

    public SalableProduct(int id, String name, String description,
                          LocalDate dateOfManufacture, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
    }

    /**
     * Base constructor for a SalableProduct.
     */

    public SalableProduct() { }

    /**
     * Grabs the product id.
     *
     * @return the id
     */

    public int getId() {
        return id;
    }

    /**
     * This sets the product id.
     *
     * @param id  new id.
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of product.
     *
     * @return  name.
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name  new name.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of product.
     *
     * @return the description.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description the new description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the manufacture date.
     *
     * @return manufacture date
     */

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    /**
     * Sets the manufacture date.
     *
     * @param dateOfManufacture the updated manufacturing date (new date).
     */

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    /**
     * Gets the product prince.
     *
     * @return price.
     */

    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param price new price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a formatted description of the product.
     *
     * @return formatted text with id, name, price, and description.
     */

    @Override
    public String toString() {
        return String.format("#%d %s ($%.2f) – %s", id, name, price, description);
    }
}
