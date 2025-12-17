package uncle_d_golf_pro_shop.models;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a health product in the store.
 * Extends SalableProduct as well as adds specific attributes
 * like healing points and ingredient list.
 */
public class Health extends SalableProduct {

    // Jackson type id field - must be first
    private final String type = "health";

    private String category;
    private int healingPoints;
    private List<String> ingredients;

    // Getter required by Jackson
    public String getType() {
        return type;
    }

    /**
     * Required by Jackson for JSON deserialization.
     */
    public Health() {
        super();
    }

    /**
     * Constructs a Health item.
     * @param id product ID
     * @param name product name
     * @param description product description
     * @param dateOfManufacture manufacture date
     * @param price product price
     * @param category category such as "Potion"
     * @param healingPoints amount healed
     * @param ingredients list of ingredients
     */
    public Health(int id, String name, String description, LocalDate dateOfManufacture,
                  double price, String category, int healingPoints, List<String> ingredients) {

        super(id, name, description, dateOfManufacture, price);
        this.category = category;
        this.healingPoints = healingPoints;
        this.ingredients = ingredients;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getHealingPoints() { return healingPoints; }
    public void setHealingPoints(int healingPoints) { this.healingPoints = healingPoints; }

    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    @Override
    public String toString() {
        return super.toString() +
                " | Category: " + category +
                " | Heals: " + healingPoints + " HP" +
                " | Ingredients: " + String.join(", ", ingredients);
    }
}
