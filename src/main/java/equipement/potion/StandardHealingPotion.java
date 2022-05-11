package equipement.potion;
/**
 * An object you can use to regain health
 */
public class StandardHealingPotion extends HealingPotion {
    public StandardHealingPotion() {
        setName("StandardHealingPotion");
        setHealingAmount(2);
        setImage("  [-] \n" +
                ".-'-'-.\n" +
                ":-...-:\n" +
                "|;:   |\n" +
                "|;:.._|\n" +
                "`-...-'");
    }
}
