package enemies;

/**
 * Goblin is a weak and filthy creature
 */
public class Goblin extends Enemy {
    public Goblin() {
        setHeal(6);
        setStrength(1);
        setImage("imageDeWizard.png");
        setName("Goblin");
    }
}
