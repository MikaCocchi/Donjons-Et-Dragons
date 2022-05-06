package character;
/**
 * Goblin is a weak and filthy creature
 */
public class Goblin extends Character{
    public Goblin() {
        this.setHeal(3);
        this.setStrength(8);
        this.setImage("imageDeWizard.png");
        this.setName("Goblin");
    }
}
