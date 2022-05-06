package character;
/**
 * Warrior is a character with a lot of health and quite decent damages
 */
public class Warrior extends Character {
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

    ////////CONSTRUCTOR
    public Warrior(String name) {
        this.setMaxHeal(5);
        this.setHeal(this.getMaxHeal());
        this.setMaxStrength(5);
        this.setStrength(this.getMaxStrength());
        this.setImage("imageDeWarrior.png");
        this.setName(name);
    }

    @Override
    public String toString() {
        return Warrior.this.getName().toString();
    }

    /**
     *this function changes the actual weapon with a new one
     * @param weapon a weapon with the class "warrior"
     *
     */
    public void changeWeapon(Object weapon) {
        this.setRightHand(weapon);
    }

    /**
     *this function changes the actual shield with a new one
     * @param shield
     *
     */
    public void changeShield(Object shield) {
        this.setLeftHand(shield);
    }
}
