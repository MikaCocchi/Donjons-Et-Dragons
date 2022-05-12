package equipement.potion;

import Cell.*;
import character.heros.Hero;
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

    @Override
    public boolean interactWithCell(Hero player, Cell cell) {
        //DISPLAY THE POTION YOU HAVE FOUND
        System.out.println(getImage() + "\nYou found a " + getName());
        player.setHeal(Math.min(player.getHeal() + getHealingAmount(), player.getMaxHeal()));
        if (player.getHeal() == player.getMaxHeal()) {
            System.out.println("your health is maxed out !");
        } else {
            System.out.println("You just drank a potion, here is your heal : " + player.getHeal());
        }
        cell.setRandomEvent(new EmptyCell());
        return true;
    }
}
