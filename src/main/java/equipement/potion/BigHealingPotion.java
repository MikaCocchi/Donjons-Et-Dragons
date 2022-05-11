package equipement.potion;
/**
 * An object you can use to regain a big amount of heal
 */
public class BigHealingPotion extends HealingPotion  {
    public BigHealingPotion() {
        setName("BigHealingPotion");
        setHealingAmount(5);
        setImage("      .___,\n" +
                "      (___)\n" +
                "      <   >\n" +
                "       ) (\n" +
                "      /`-.\\\n" +
                "     /     \\\n" +
                "    / _    _\\\n" +
                "   :,' `-.' `:\n" +
                "   |         |\n" +
                "   :         ;\n" +
                "    \\       /\n" +
                "     `.___.'");
    }
}
