import character.heros.Hero;
import character.heros.Warrior;
import character.heros.Wizard;

import java.util.Scanner;

/**
 * this class controls whole application
 */
public class Game {
    ///////////MAIN///////////
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        boolean characterFinished = false;
        Hero player = null;
        while (!characterFinished) {
            String characterName = chooseAName();
            player = chooseAClass(characterName);
            characterFinished = true;
        }
        System.out.println("to start the game, enter 'start'");
        if (keyboard.nextLine().equals("start")) {
            startPlaying(player);
        }
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
                    player = createCharacter(characterClass, characterName);
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
    public static Hero createCharacter(String characterClass, String characterName) {
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
    public static void startPlaying(Hero player) {
        Scanner keyboard = new Scanner(System.in);
        Board board = new Board();
        System.out.println("To move forward enter 'c', to see your stats enter 'st' and if you want to stop playing enter 'exit'");
        while (board.getPosition() < board.getBoard().length) {
            String keyboardInput = keyboard.nextLine();
            switch (keyboardInput) {
                case "c":
                    board.moveForwardAndPlay(throwTheDice(), player);
                    break;
                case "exit":
                    System.out.println("Thanks for playing !");
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