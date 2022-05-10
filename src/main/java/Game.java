import character.Character;
import character.Warrior;
import character.Wizard;

import java.util.Scanner;

public class Game {
    ///////////MAIN///////////
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        boolean characterFinished = false;
        Character player = null;
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
    public static Character chooseAClass(String characterName) {
        Character player = null;
        Scanner keyboard = new Scanner(System.in);
        boolean classFinished = false;
        while (!classFinished) {
            System.out.print("Welcome " + characterName + " please choose your class: ");
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
     * @param characterClass String contains the class of the character
     * @param characterName String contains the name of the character
     * @return an object type Warrior or Wizard
     */
    public static Character createCharacter(String characterClass, String characterName) {
        Character character = null;
        if (characterClass.equals("Warrior")) {
            character = new Warrior(characterName);

        } else if (characterClass.equals("Wizard")) {
            character = new Wizard(characterName);

        }
        return character;
    }

    /**
     * function starts the process to play the game
     */
    public static void startPlaying(Character player) {
        Scanner keyboard = new Scanner(System.in);
        Board board = new Board();
        System.out.println("mon board : "+ board);
        System.out.println("To move forward enter 'c' if you want to stop playing enter 'exit'");
        while (board.getPosition() < board.getBoard().length) {
            String keyboardInput = keyboard.nextLine();
            if (keyboardInput.equals("c")) {
                board.moveForward(throwTheDice(), player);
            } else if (keyboardInput.equals("exit")) {
                System.out.println("Thanks for playing !");
                System.exit(0);
            }
        }
    }

    /**
     * this function returns a random integer between 1 and 6
     * @return int
     */
    public static int throwTheDice() {
        return (int) (Math.random() * 6) + 1;
    }
}