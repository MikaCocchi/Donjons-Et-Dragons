package character.enemies;

import character.Character;
import character.heros.Hero;
import interfaces.BoardEvent;

/**
 * A super class which contains all the stats an enemy needs
 */
public abstract class Enemy extends Character implements BoardEvent {
    @Override
    public void interactWithCell(Hero player) {
        //DISPLAY THE ENEMY YOU ARE FIGHTING
        System.out.println(getImage() + "\n You are fighting against a " + getName());
        //Fight an Enemy
        while (player.getHeal() > 0 && getHeal() > 0) {
            //ENEMY HEALTH MINUS PLAYER STRENGTH
            setHeal(getHeal() - player.getStrength());
            if (getHeal() > 0) {
                //CHARACTER HEALTH MINUS ENEMY STRENGTH
                player.setHeal(player.getHeal() - getStrength());
                if (player.getHeal() <= 0) {
                    System.out.println("You have been defeated !\n" +
                            "  _____                         ____                 \n" +
                            " / ____|                       / __ \\                \n" +
                            "| |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ \n" +
                            "| | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|\n" +
                            "| |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   \n" +
                            " \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   ");
                    System.exit(0);
                }
            } else {
                System.out.println(getName() + " has been killed");
            }
        }
    }
}
