package character;
/**
 * Warrior is a character with a lot of health and quite decent damages
 */
public class Warrior extends Character {


    ////////CONSTRUCTOR
    public Warrior(String name) {
        setMaxHeal(10);
        setHeal(5);
        setMaxStrength(10);
        setStrength(5);
        setImage("imageDeWarrior.png");
        setName(name);
    }



}
