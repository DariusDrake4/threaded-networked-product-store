package uncle_d_golf_pro_shop.models;

import java.time.LocalDate;

/**
 * Represents an armor product in the store.
 * Extends SalableProduct and adds armor-specific attributes.
 */
public class Armor extends SalableProduct {

    // Jackson type id field - must be first
    private final String type = "armor";

    private String armorType;
    private double defenseBonus;

    // Getter required by Jackson
    public String getType() {
        return type;
    }

    /**
     * Required by Jackson for JSON deserialization.
     */
    public Armor() {
        super();
    }

    /**
     * Constructs a new Armor item.
     * @param id product ID
     * @param name armor name
     * @param description armor description
     * @param dateOfManufacture manufacture date
     * @param price armor price
     * @param armorType type of armor (Shield, Helmet, etc.)
     * @param defenseBonus defense value bonus
     */
    public Armor(int id, String name, String description, LocalDate dateOfManufacture,
                 double price, String armorType, double defenseBonus) {

        super(id, name, description, dateOfManufacture, price);
        this.armorType = armorType;
        this.defenseBonus = defenseBonus;
    }

    public String getArmorType() { return armorType; }
    public void setArmorType(String armorType) { this.armorType = armorType; }

    public double getDefenseBonus() { return defenseBonus; }
    public void setDefenseBonus(double defenseBonus) { this.defenseBonus = defenseBonus; }

    @Override
    public String toString() {
        return super.toString() +
                " | Armor Type: " + armorType +
                " | Defense Bonus: " + defenseBonus;
    }
}
