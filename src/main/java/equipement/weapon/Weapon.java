package equipement.weapon;

import character.heros.Hero;
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
    @Override
    public void interactWithCell(Hero player) {
        //DISPLAY THE WEAPON YOU HAVE FOUND
        System.out.println(getImage() + "\nyou just found a " + getName());
        if (getClassType().equals(player.getClass().getSimpleName())) {
            player.setStrength(Math.min(player.getStrength() + getAttackPower(), player.getMaxStrength()));
            if (player.getStrength() == player.getMaxStrength()) {
                System.out.println("your strength is maxed out !");
            } else {
                System.out.println("You just found a " + getName() + " ,here is your strength : " + player.getStrength());
            }
        } else {
            System.out.println("You can't use this weapon");
        }
    }
}
