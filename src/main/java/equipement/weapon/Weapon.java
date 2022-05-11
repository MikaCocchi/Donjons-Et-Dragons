package equipement.weapon;

import interfaces.BoardEvent;

/**
 * A super class which contains all the stats a weapon needs
 */
public abstract class Weapon implements BoardEvent {
    private int attackPower;

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    private String name;

    private String classType;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
