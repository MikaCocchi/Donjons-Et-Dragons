package character;

/**
 * Wizard is a character which has a small amount of health but has a lot of damages
 */
public class Wizard extends Character {
    private Object rightHand;
    private Object leftHand;

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

    public Wizard(String name) {
        this.setMaxHeal(3);
        this.setHeal(this.getMaxHeal());
        this.setMaxStrength(8);
        this.setStrength(this.getMaxStrength());
        this.setImage("imageDeWizard.png");
        this.setName(name);
    }

//    @Override
//    public String toString() {
//        return Wizard.this.getName().toString();
//    }

    /**
     * this function changes the actual spell with a new one
     *
     * @param newSpell
     */
    public void changeSpell(Object newSpell) {
        this.setRightHand(newSpell);
    }

    /**
     * this function changes the actual filter with a new one
     *
     * @param newFilter
     */
    public void changeFilter(Object newFilter) {
        this.setLeftHand(newFilter);
    }
}
