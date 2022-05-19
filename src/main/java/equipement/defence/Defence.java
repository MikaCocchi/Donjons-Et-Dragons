package equipement.defence;


import character.heroes.Hero;
import interfaces.BoardEvent;
import Cell.*;

public abstract class Defence implements BoardEvent {

    private int defenceAmount;
    private int usageLeft;
    private String name;
    private String image;


    @Override
    public boolean interactWithCell(Hero player, Cell cell, boolean useDefenceItem) {
        //DISPLAY THE WEAPON YOU HAVE FOUND
        System.out.println(getImage() + "\nyou just found a " + getName());
        if (getName().equals("Philter")) {
            player.setLeftHand(new Philter());
        } else if (getName().equals("Shield")) {
            player.setLeftHand(new Shield());
        } else {
            System.out.println("How did you get here ? -_-");
        }
        cell.setRandomEvent(new EmptyCell());
        return true;

    }

    public int getDefenceAmount() {
        return defenceAmount;
    }

    public void setDefenceAmount(int defenceAmount) {
        this.defenceAmount = defenceAmount;
    }

    public int getUsageLeft() {
        return usageLeft;
    }

    public void setUsageLeft(int usageLeft) {
        this.usageLeft = usageLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
