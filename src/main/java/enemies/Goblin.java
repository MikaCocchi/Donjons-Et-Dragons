package enemies;

/**
 * Goblin is a weak and filthy creature
 */
public class Goblin extends Enemy {
    public Goblin() {
        setHeal(6);
        setStrength(1);
        setImage("        .-\"\"\"\".\n" +
                "       /       \\\n" +
                "   __ /   .-.  .\\\n" +
                "  /  `\\  /   \\/  \\\n" +
                "  |  _ \\/   .==.==.\n" +
                "  | (   \\  /____\\__\\\n" +
                "   \\ \\      (_()(_()\n" +
                "    \\ \\            '---._\n" +
                "     \\                   \\_\n" +
                "  /\\ |`       (__)________/\n" +
                " /  \\|     /\\___/\n" +
                "|    \\     \\||VV\n" +
                "|     \\     \\|\"\"\"\",\n" +
                "|      \\     ______)\n" +
                "\\       \\  /`\n" +
                "         \\(");
        setName("Goblin");
    }
}
