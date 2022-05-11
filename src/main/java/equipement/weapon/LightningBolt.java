package equipement.weapon;

/**
 * A standard spell any wizard should know
 */
public class LightningBolt extends Weapon {
    public LightningBolt() {
        setAttackPower(2);
        setName("LightningBolt");
        setClassType("Wizard");
        setImage("    ___(                        )\n" +
                "   (                          _)\n" +
                "  (_                       __))\n" +
                "    ((                _____)\n" +
                "      (_________)----'\n" +
                "         _/  /\n" +
                "        /  _/\n" +
                "      _/  /\n" +
                "     / __/\n" +
                "   _/ /\n" +
                "  /__/\n" +
                " //\n" +
                "/'");
    }
}
