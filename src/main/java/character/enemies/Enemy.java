package character.enemies;

import Cell.*;
import character.Character;
import character.heroes.Hero;
import equipement.defence.*;
import interfaces.BoardEvent;


/**
 * A super class which contains all the stats an enemy needs
 */
public abstract class Enemy extends Character implements BoardEvent {
    @Override
    public boolean interactWithCell(Hero player, Cell cell, boolean useDefenceItem) {
        String defeatMessage = "You have been defeated !\n" +
                "  _____                         ____                 \n" +
                " / ____|                       / __ \\                \n" +
                "| |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ \n" +
                "| | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|\n" +
                "| |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   \n" +
                " \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   ";
        if (useDefenceItem) {
            Defence defenceItem = (Defence) player.getLeftHand();
            if (defenceItem.getName().equals("EmptyLeftHand")) {
                System.out.println("You tried to protect yourself with your bare hands, due to that you lost more health !");
            }
            // Use Shield but player gets hit first
            player.setHeal(Math.min(player.getHeal() - (getStrength() - defenceItem.getDefenceAmount()), player.getMaxHeal()));
            // Minus 1 durability on your shield
            defenceItem.setUsageLeft(defenceItem.getUsageLeft() - 1);
            if (defenceItem.getUsageLeft() == 0) {
                System.out.println("Your " + defenceItem.getName() +" is out of durability");
                player.setLeftHand(new EmptyLeftHand());
            }
            if (player.getHeal() > 0) {
                setHeal(getHeal() - player.getStrength());
                if (getHeal() <= 0) {
                    System.out.println(getName() + " has been killed !");
                    return true;
                }
            } else {
                System.out.println(defeatMessage);
                System.exit(0);
            }
            System.out.println("The fight is not over, your health : " + player.getHeal());
        } else {
            //ENEMY HEALTH MINUS PLAYER STRENGTH
            setHeal(getHeal() - player.getStrength());
            if (getHeal() > 0) {
                //CHARACTER HEALTH MINUS ENEMY STRENGTH
                player.setHeal(player.getHeal() - getStrength());
                if (player.getHeal() <= 0) {
                    System.out.println(defeatMessage);
                    System.exit(0);
                }
            } else {
                System.out.println(getName() + " has been killed !");
                cell.setRandomEvent(new EmptyCell());
                return true;
            }
            System.out.println("The fight is not over, your health : " + player.getHeal());
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n" + getImage() + "\n" + getClass().getSimpleName() + "'s statistics : " + "\n-health : " + getHeal() + "\n-strength : " + getStrength();
    }
}

