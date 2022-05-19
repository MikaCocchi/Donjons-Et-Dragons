package character.heroes;

import character.Character;
import character.enemies.Enemy;
import equipement.defence.Defence;

/**
 * this class extends Character and defines all Heroes the user can choose
 */
public abstract class Hero extends Character {
    private int maxHeal;
    private int maxStrength;
    private Object rightHand;
    private Defence leftHand;

    ///////////GETTER and SETTER

///////////////NOT YET////////////////



    /**
     * this function changes the actual shield with a new one
     *
     * @param shield
     */
    public void changeShield(Defence shield) {
        this.setLeftHand(shield);
    }
//////////////////////////////////////

    /**
     * this function display all the character stats in the terminal
     */
    @Override
    public String toString() {
        return getImage() + "\n" + getClass().getSimpleName() + " here are your statistics : \n-name : " + getName() + "\n-health : " + getHeal() + "\n-strength : " + getStrength() + "\n-leftHand : " + getLeftHand().getClass().getSimpleName();
    }


    public Object getRightHand() {
        return rightHand;
    }

    public void setRightHand(Object rightHand) {
        this.rightHand = rightHand;
    }

    public Object getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Defence leftHand) {
        this.leftHand = leftHand;
    }

    public int getMaxHeal() {
        return maxHeal;
    }

    public void setMaxHeal(int maxHeal) {
        this.maxHeal = maxHeal;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(int maxStrength) {
        this.maxStrength = maxStrength;
    }
}
