package enemies;

import interfaces.BoardEvent;

/**
 * A super class which contains all the stats an enemy needs
 */
public abstract class Enemy implements BoardEvent {
    private int heal;
    private int strength;
    private String image;
    private String name;

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
