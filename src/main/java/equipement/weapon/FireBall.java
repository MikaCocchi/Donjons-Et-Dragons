package equipement.weapon;

/**
 * A very powerful spell
 */
public class FireBall extends Weapon {
    public FireBall() {
        setAttackPower(7);
        setName("FireBall");
        setClassType("Wizard");
        setImage("                        |\n" +
                "                    .   |\n" +
                "                        |\n" +
                "          \\    *        |     *    .  /\n" +
                "            \\        *  |  .        /\n" +
                "         .    \\     ___---___     /    .  \n" +
                "                \\.--         --./     \n" +
                "     ~-_    *  ./               \\.   *   _-~\n" +
                "        ~-_   /                   \\   _-~     *\n" +
                "   *       ~-/                     \\-~        \n" +
                "     .      |                       |      .\n" +
                "         * |                         | *     \n" +
                "-----------|                         |-----------\n" +
                "  .        |                         |        .    \n" +
                "        *   |                       | *\n" +
                "           _-\\                     /-_    *\n" +
                "     .  _-~ . \\                   /   ~-_     \n" +
                "     _-~       `\\               /'*      ~-_  \n" +
                "    ~           /`--___   ___--'\\           ~\n" +
                "           *  /        ---     .  \\   \n" +
                "            /     *     |           \\\n" +
                "          /             |   *         \\\n" +
                "                     .  |        .\n" +
                "                        |\n" +
                "                        |");
    }
}
