package uncle_d_golf_pro_shop.models;

import java.time.LocalDate;

/**
 * In place of a weapon product in the store.
 * Extends SalableProduct as well as adds specific attributes to the weapon.
 */
public class Weapon extends SalableProduct {

    // Jackson type id field - required for JSON load
    private final String type = "weapon";

    private String weaponType;
    private int hitValue;
    private double carryWeight;


    /**
     * Gets the Jackson type identifier for this class.
     *
     * @return the type string
     */

    public String getType() {
        return type;
    }

    /**
     * Required by Jackson for JSON deserialization.
     * This constructor lets Jackson rebuild Weapon objects when loading from a file.
     */

    public Weapon() {
        super(); // calls SalableProduct's no-arg constructor
    }

    /**
     * Constructs a new Weapon.
     * @param id to specific product.
     * @param name the name of the specific weapon.
     * @param description the description of the weapon.
     * @param dateOfManufacture the manufacture date.
     * @param price the price of the weapon.
     * @param weaponType the type of weapon (sword, bow, etc).
     * @param hitValue the attack power of the weapon.
     * @param carryWeight the weight of the weapon.
     */

    public Weapon(int id, String name, String description, LocalDate dateOfManufacture,
                  double price, String weaponType, int hitValue, double carryWeight) {
        super(id, name, description, dateOfManufacture, price);
        this.weaponType = weaponType;
        this.hitValue = hitValue;
        this.carryWeight = carryWeight;
    }

    /**
     * Gets the type of weapon.
     *
     * @return the weapon type.
     */
    public String getWeaponType() { return weaponType; }

    /**
     * Sets the weapon type.
     *
     * @param weaponType the new weapon type.
     */
    public void setWeaponType(String weaponType) { this.weaponType = weaponType; }

    /**
     * Gets the hit value (attack power) of the weapon.
     *
     * @return the hit value.
     */
    public int getHitValue() { return hitValue; }

    /**
     * Sets the hit value (attack power) of the weapon.
     *
     * @param hitValue the new hit value.
     */
    public void setHitValue(int hitValue) { this.hitValue = hitValue; }

    /**
     * Gets the carry weight of the weapon.
     *
     * @return the weapon's weight.
     */
    public double getCarryWeight() { return carryWeight; }

    /**
     * Sets the carry weight of the weapon.
     *
     * @param carryWeight the new carry weight.
     */
    public void setCarryWeight(double carryWeight) { this.carryWeight = carryWeight; }

    /**
     * Returns a descriptive string of the weapon including its weapon-specific stats.
     *
     * @return formatted string containing weapon details.
     */

    @Override
    public String toString() {
        return super.toString() +
                " | Weapon Type: " + weaponType +
                " | Hit Value: " + hitValue +
                " | Carry Weight: " + carryWeight;
    }
}
