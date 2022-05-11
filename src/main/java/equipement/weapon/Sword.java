package equipement.weapon;

/**
 * A very sharp and mighty sword
 */
public class Sword extends Weapon {
    public Sword() {
        setAttackPower(5);
        setName("Sword");
        setClassType("Warrior");
        setImage(",_._._._._._._._._|__________________________________________________________,\n" +
                 "|_|_|_|_|_|_|_|_|_|_________________________________________________________/\n" +
                 "                  !");
    }
}
