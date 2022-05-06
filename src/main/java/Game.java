import character.Character;
import character.Warrior;
import character.Wizard;
import equipement.potion.BigHealingPotion;
import equipement.potion.HealingPotion;

import java.util.Scanner;

public class Game {
    ///////////MAIN///////////
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean characterFinished = false;
        Character character = null;
        while (!characterFinished) {
            String characterName = chooseAName();
            character = chooseAClass(characterName);
            characterFinished = true;
        }
        System.out.println("to start the game, enter 'start'");
        if (keyboard.nextLine().equals("start")) {
            startPlaying();
        }
    }

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
        Character character = null;
        Scanner keyboard = new Scanner(System.in);
        boolean classFinished = false;
        while (!classFinished) {
            System.out.print("Welcome " + characterName + " please choose your class: ");
            String characterClass = keyboard.nextLine();
            System.out.println(characterClass + " is that correct ? (yes or no)");
            if (keyboard.nextLine().equals("yes")) {
                try {
                    character = createCharacter(characterClass, characterName);
                    character.getAllStats(characterClass);
                    classFinished = true;

                } catch (Exception error) {
                    System.out.println("Please choose a correct class");
                }

            }
        }
        return character;
    }

    public static Character createCharacter(String characterClass, String characterName) {
        Character character = null;
        if (characterClass.equals("Warrior")) {
            character = new Warrior(characterName);

        } else if (characterClass.equals("Wizard")) {
            character = new Wizard(characterName);

        }
        return character;
    }

    public static void startPlaying() {
        Scanner keyboard = new Scanner(System.in);
        Board board = new Board();
        System.out.println("To move forward enter 'c' if you want to stop playing enter 'exit'");
        while (board.getPosition() < 64) {
            String keyboardInput = keyboard.nextLine();
            if (keyboardInput.equals("c")) {
                board.moveForward(throwTheDice());
            } else if (keyboardInput.equals("exit")) {
                System.out.println("Thanks for playing !");
                System.exit(0);
            }
        }

    }

    public static int throwTheDice() {
        return (int) (Math.random() * 5) + 1;
    }

}