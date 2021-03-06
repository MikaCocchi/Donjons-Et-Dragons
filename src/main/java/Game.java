import character.heroes.Hero;
import character.heroes.Warrior;
import character.heroes.Wizard;
import exeptions.BoardEndReachedExeption;

import java.util.List;
import java.util.Scanner;

/**
 * this class controls whole application
 */
public class Game {


    ///////////MAIN///////////
    public static void main(String[] args) {

        DataBase db = new DataBase();
        Scanner keyboard = new Scanner(System.in);
        Hero player;
        System.out.println("do you want to load a saved character ? (y or n)");
        if (keyboard.nextLine().equals("y")) {
            player = db.loadSavedCharacter();
        } else {
            player = createHero(db);
            db.saveCreatedHero(player);
        }
        System.out.println("to start the game, enter 'start'");
        String keyboardStartInput = keyboard.nextLine();
        while (!keyboardStartInput.equals("start")) {
            System.out.println("to start the game, enter 'start'");
            keyboardStartInput = keyboard.nextLine();
        }
        startPlaying(player, db);
    }

    public static Hero createHero(DataBase db) {
        String characterName = null;
        boolean nameChosen = false;
        while (!nameChosen) {
            characterName = chooseAName();
            List<String> names = db.getAllNames();
            for (String name : names) {
                if (characterName.equalsIgnoreCase(name)) {
                    System.out.println("name already taken please choose another one");
                    nameChosen = false;
                    break;
                } else if (!nameChosen) {
                    nameChosen = true;
                }
            }
        }

        return chooseAClass(characterName);
    }


    /**
     * function asks the user to choose a name, it returns the input
     *
     * @return characterName
     */
    public static String chooseAName() {
        Scanner keyboard = new Scanner(System.in);
        boolean nameFinished = false;
        String characterName = null;
        while (!nameFinished) {
            System.out.print("Hello apprentice what is your name : ");
            characterName = keyboard.nextLine();
            System.out.println(characterName + " is that correct ? (yes or no)");
            if (keyboard.nextLine().equals("yes")) {
                nameFinished = true;
            }
        }
        return characterName;
    }

    /**
     * function asks the user to choose a class and when it's done, it creates the character
     *
     * @param characterName a string which contains the name of the character
     * @return Character
     */
    public static Hero chooseAClass(String characterName) {
        Hero player = null;
        Scanner keyboard = new Scanner(System.in);
        boolean classFinished = false;
        while (!classFinished) {
            System.out.print("Welcome " + characterName + " the classes available are:\n- wizard\n- warrior \nplease choose your class: ");
            String characterClass = keyboard.nextLine();
            System.out.println(characterClass + " is that correct ? (yes or no)");
            if (keyboard.nextLine().equals("yes")) {
                try {
                    player = heroInstantiation(characterClass, characterName);
                    System.out.println(player);
                    classFinished = true;

                } catch (Exception error) {
                    System.out.println("Please choose a correct class");
                }

            }
        }
        return player;
    }

    /**
     * this function instantiate an object type Warrior or Wizard
     *
     * @param characterClass String contains the class of the character
     * @param characterName  String contains the name of the character
     * @return an object type Warrior or Wizard
     */
    public static Hero heroInstantiation(String characterClass, String characterName) {
        Hero hero = null;
        if (characterClass.equals("Warrior") || characterClass.equals("warrior")) {
            hero = new Warrior(characterName);

        } else if (characterClass.equals("Wizard") || characterClass.equals("wizard")) {
            hero = new Wizard(characterName);

        }
        return hero;
    }

    /**
     * function starts the process to play the game
     */
    public static void startPlaying(Hero player, DataBase db) {

        Scanner keyboard = new Scanner(System.in);
        Board board = new Board();
//        board.setBoard(db.getSavedBoard(player));
        System.out.println("To move forward enter 'c', to see your stats enter 'st' and if you want to stop playing enter 'exit'");
        while (board.getPosition() < board.getBoard().length) {
            String keyboardInput = keyboard.nextLine();
            switch (keyboardInput) {
                case "c":
                    try {
                        board.moveForwardAndPlay(throwTheDice(), player, db);
                    } catch (BoardEndReachedExeption e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "exit":
                    db.saveHeroCurrentStats(player);
                    db.saveBoard(player,board.getBoard());
                    System.out.println("Thanks for playing ! Your board and character has been saved !");
                    System.exit(0);
                case "st":
                    System.out.println(player);
                    break;
            }
            System.out.println("\n-------------------------------------------------------------------------------------------------\n");
        }
    }

    /**
     * this function returns a random integer between 1 and 6
     *
     * @return int
     */
    public static int throwTheDice() {
        return (int) (Math.random() * 6) + 1;
    }


}