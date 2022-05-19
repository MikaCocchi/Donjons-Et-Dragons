package character.heroes;

import equipement.defence.EmptyLeftHand;

/**
 * Warrior is a character with a lot of health and with quite decent damages
 */
public class Warrior extends Hero {


    ////////CONSTRUCTOR
    public Warrior(String name) {
        setMaxHeal(10);
        setHeal(5);
        setMaxStrength(10);
        setStrength(5);
        setImage("  ,   A           {}\n" +
                " / \\, | ,        .--.\n" +
                "|    =|= >      /.--.\\\n" +
                " \\ /` | `       |====|\n" +
                "  `   |         |`::`|  \n" +
                "      |     .-;`\\..../`;_.-^-._\n" +
                "     /\\\\/  /  |...::..|`   :   `|\n" +
                "     |:'\\ |   /'''::''|   .:.   |\n" +
                "      \\ /\\;-,/\\   ::  |..:::::..|\n" +
                "      |\\ <` >  >._::_.| ':::::' |\n" +
                "      | `\"\"`  /   ^^  |   ':'   |\n" +
                "      |       |       \\    :    /\n" +
                "      |       |        \\   :   / \n" +
                "      |       |___/\\___|`-.:.-`\n" +
                "      |        \\_ || _/    `\n" +
                "      |        <_ >< _>\n" +
                "      |        |  ||  |\n" +
                "      |        |  ||  |\n" +
                "      |       _\\.:||:./_\n" +
                "      |      /____/\\____\\");
        setName(name);
        setLeftHand(new EmptyLeftHand());
    }
    public Warrior() {
        setMaxHeal(10);
        setMaxStrength(10);
        setImage("  ,   A           {}\n" +
                " / \\, | ,        .--.\n" +
                "|    =|= >      /.--.\\\n" +
                " \\ /` | `       |====|\n" +
                "  `   |         |`::`|  \n" +
                "      |     .-;`\\..../`;_.-^-._\n" +
                "     /\\\\/  /  |...::..|`   :   `|\n" +
                "     |:'\\ |   /'''::''|   .:.   |\n" +
                "      \\ /\\;-,/\\   ::  |..:::::..|\n" +
                "      |\\ <` >  >._::_.| ':::::' |\n" +
                "      | `\"\"`  /   ^^  |   ':'   |\n" +
                "      |       |       \\    :    /\n" +
                "      |       |        \\   :   / \n" +
                "      |       |___/\\___|`-.:.-`\n" +
                "      |        \\_ || _/    `\n" +
                "      |        <_ >< _>\n" +
                "      |        |  ||  |\n" +
                "      |        |  ||  |\n" +
                "      |       _\\.:||:./_\n" +
                "      |      /____/\\____\\");
        setLeftHand(new EmptyLeftHand());
    }
}
