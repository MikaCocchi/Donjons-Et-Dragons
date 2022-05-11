package equipement.potion;

import interfaces.BoardEvent;

/**
 * A super class which contains all the stats a potion needs
 */
public abstract class HealingPotion implements BoardEvent {

    private String name;
    private int healingAmount;
    private String image;


    @Override
    public String toString() {
        return this.name + " " + this.healingAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
