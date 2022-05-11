package character.heros;

import character.Character;

public abstract class Hero extends Character {
    private int maxHeal;
    private int maxStrength;
    private Object rightHand;
    private Object leftHand;

    ///////////GETTER and SETTER
    public Object getRightHand() {
        return rightHand;
    }

    public void setRightHand(Object rightHand) {
        this.rightHand = rightHand;
    }

    public Object getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Object leftHand) {
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
///////////////NOT YET////////////////

    /**
     * this function changes the actual weapon with a new one
     *
     * @param weapon a weapon with the class "warrior"
     */
    public void changeWeapon(Object weapon) {
        this.setRightHand(weapon);
    }

    /**
     * this function changes the actual shield with a new one
     *
     * @param shield
     */
    public void changeShield(Object shield) {
        this.setLeftHand(shield);
    }
//////////////////////////////////////

    /**
     * this function display all the character stats in the terminal
     */
    @Override
    public String toString() {
        return getImage() + "\n" + getClass().getSimpleName() + " here are your statistics : \n-name : " + getName() + "\n-health : " + getHeal() + "\n-strength : " + getStrength();
    }
}
