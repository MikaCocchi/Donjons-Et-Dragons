import Cell.*;
import character.enemies.Dragon;
import character.enemies.Goblin;
import character.enemies.Warlock;
import character.heroes.Hero;
import equipement.defence.Philter;
import equipement.defence.Shield;
import equipement.potion.BigHealingPotion;
import equipement.potion.StandardHealingPotion;
import equipement.weapon.*;
import exeptions.BoardEndReachedExeption;

import java.util.Arrays;
import java.util.Scanner;

/**
 * this is the game board and its functions
 */
public class Board {
    private Cell[] board = new Cell[64];

    private int position = 0;

    ///////////////GETTER and SETTER /////////////////
    public Cell[] getBoard() {
        return board;
    }


    public int getPosition() {
        return position;
    }

    /**
     * this function sets the variable position when it is superior to the board length else it throws an BoardEndReachedExeption
     *
     * @param positionWithDiceThrow an int which represent the actual position of the player + the dice throw
     * @throws BoardEndReachedExeption
     */
    public void setPosition(int positionWithDiceThrow) throws BoardEndReachedExeption {
        if (positionWithDiceThrow >= board.length) {
            this.position = 64;
            throw new BoardEndReachedExeption("you have reached the end of the board");
        }
        this.position = positionWithDiceThrow;
    }

    //////////////END GETTER and SETTER/////////////
    public Board() {
        ////////// Create an array with a certain amount of each BoardEvents
        for (int i = 0; i < 64; i++) {
            Cell test = new Cell();
            if (i < 4) {
                test.setRandomEvent(new Dragon());
            } else if (i < 14) {
                test.setRandomEvent(new Warlock());
            } else if (i < 24) {
                test.setRandomEvent(new Goblin());
            } else if (i < 29) {
                test.setRandomEvent(new Stick());
            } else if (i < 33) {
                test.setRandomEvent(new Sword());
            } else if (i < 38) {
                test.setRandomEvent(new LightningBolt());
            } else if (i < 41) {
                test.setRandomEvent(new FireBall());
            } else if (i < 47) {
                test.setRandomEvent(new StandardHealingPotion());
            } else if (i < 53) {
                test.setRandomEvent(new BigHealingPotion());
            } else if (i < 56) {
                test.setRandomEvent(new Shield());
            } else if (i < 59) {
                test.setRandomEvent(new Philter());
            } else {
                test.setRandomEvent(new EmptyCell());
            }
            board[i] = test;
        }
        ////////////SHUFFLE ARRAY
        int boardLength = board.length;
        for (int i = 0; i < boardLength; i++) {
            int random = i + (int) (Math.random() * (boardLength - i));
            Cell temporary = board[random];
            board[random] = board[i];
            board[i] = temporary;
        }

    }

    /**
     * function moves the character, depending on the diceThrow
     *
     * @param diceThrow An int which represent how far the character will move on the board
     */
    public void moveForwardAndPlay(int diceThrow, Hero player, DataBase db) throws BoardEndReachedExeption {
        int positionWithDiceThrow = getPosition() + diceThrow;
        try {
            setPosition(positionWithDiceThrow);
        } catch (BoardEndReachedExeption e) {

            db.deleteHero(player.getName());
            System.out.println("You have reached the edge of the board. Well done !" +
                    "\n             ___________\n" +
                    "            '._==_==_=_.'\n" +
                    "            .-\\:      /-.\n" +
                    "           | (|:.     |) |\n" +
                    "            '-|:.     |-'\n" +
                    "              \\::.    /\n" +
                    "               '::. .'\n" +
                    "                 ) (\n" +
                    "               _.' '._\n" +
                    "              `\"\"\"\"\"\"\"`");
        }
        System.out.println("You are now placed at space : " + positionWithDiceThrow);
        boolean roundFinished = false;
        while (!roundFinished) {
            if (board[getPosition()].getRandomEvent().getClass().getSimpleName().equals("Goblin") || board[getPosition()].getRandomEvent().getClass().getSimpleName().equals("Warlock") || board[getPosition()].getRandomEvent().getClass().getSimpleName().equals("Dragon")) {
                //DISPLAY THE ENEMY YOU ARE FIGHTING
                System.out.println(board[getPosition()].getRandomEvent());
                Scanner keyboard = new Scanner(System.in);
                String keyboardInput = "oui";
                while (!keyboardInput.equals("f") && !keyboardInput.equals("F") && !keyboardInput.equals("r") && !keyboardInput.equals("R")) {
                    System.out.println("to fight against this enemy enter 'f' ,to run away enter 'r'");
                    keyboardInput = keyboard.nextLine();
                }
                if (keyboardInput.equals("f") || keyboardInput.equals("F")) {
                    System.out.println("Do you want to defend yourself using your " + player.getLeftHand().getClass().getSimpleName() + " and then fight back ?");
                    keyboardInput = keyboard.nextLine();
                    boolean useDefenceItem = keyboardInput.equals("y");
                    //PLAY THE ROUND
                    roundFinished = board[getPosition()].getRandomEvent().interactWithCell(player, board[getPosition()], useDefenceItem);
                } else {
                    int DiceThrowToGoBack = (int) (Math.random() * 6) + 1;
                    setPosition(Math.max(getPosition() - DiceThrowToGoBack, 0));
                    System.out.println("You went back to the space : " + getPosition());
                }
            } else {
                //PLAY THE ROUND
                roundFinished = board[getPosition()].getRandomEvent().interactWithCell(player, board[getPosition()], false);
            }
        }
    }


    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
