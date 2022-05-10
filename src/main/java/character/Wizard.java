package character;

/**
 * Wizard is a character which has a small amount of health but has a lot of damages
 */
public class Wizard extends Character {
    public Wizard(String name) {
        setMaxHeal(6);
        setHeal(3);
        setMaxStrength(15);
        setStrength(8);
        setImage("imageDeWizard.png");
        setName(name);
    }
}
