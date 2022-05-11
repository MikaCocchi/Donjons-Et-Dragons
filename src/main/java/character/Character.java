package character;

/**
 * a super class which contains all the stats a player's character need
 */
public abstract class Character {
    private int maxHeal;
    private int heal;
    private int maxStrength;
    private int strength;
    private String image;
    private String name;
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

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(int maxStrength) {
        this.maxStrength = maxStrength;
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

    /**
     * this function display all the character stats in the terminal
     */
    @Override
    public String toString() {
        return getImage() + "\n" + getClass().getSimpleName() + " here are your statistics : \n-name : " + getName() + "\n-health : " + getHeal() + "\n-strength : " + getStrength();
    }
}
