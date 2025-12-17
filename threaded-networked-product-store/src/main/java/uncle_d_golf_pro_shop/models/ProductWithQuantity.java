package uncle_d_golf_pro_shop.models;

import java.time.LocalDate;

/**
 * Represents a poroduct that includes a quantity - for example,
 * an item stored in the inventory or it is placed in a shopping cart.
 *
 * Extends {@link SalableProduct} so it obtains the shared product
 * attributes like ID, name, description, manufacture date, and price
 *
 */
public class ProductWithQuantity extends SalableProduct {

    /**
     * The number of units for if the product is available or in the cart.
     *
     */
    private final String type = "productWithQuantity";
    private int quantity;




    /**
     * Default constructor which required by Jackson for JSON deserialization.
     * Initializes the object with the default values.
     */
    public ProductWithQuantity() {
        super();
    }

    /**
     * Constructs a new ProductWithQuantity with all properties.
     *
     * @param id                the unique product ID
     * @param name              the product name
     * @param description       the product description
     * @param dateOfManufacture the date the product was made
     * @param price             the price of the product
     * @param quantity           how many units of the product that exist
     */
    public ProductWithQuantity(int id, String name, String description, LocalDate dateOfManufacture, double price, int quantity) {
        super(id, name, description, dateOfManufacture, price);
        this.quantity = quantity;
    }

    /**
     * Retrieves quantity of the product
     * @return retrieves the number of units available or in the cart
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     * @param quantity retrieves the number of units available or in the cart
     *
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a formatted string which represent the product with quantity.
     * @return product details and includes quantity
     */
    @Override
    public String toString() {
        return super.toString() + " | Quantity: " + quantity;
    }
}


