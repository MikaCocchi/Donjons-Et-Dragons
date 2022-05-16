import Cell.*;
import character.enemies.Dragon;
import character.enemies.Goblin;
import character.enemies.Warlock;
import character.heroes.Hero;
import equipement.potion.BigHealingPotion;
import equipement.potion.StandardHealingPotion;
import equipement.weapon.*;

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

    public void setBoard(Cell[] board) {
        this.board = board;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
    public void moveForwardAndPlay(int diceThrow, Hero player, DataBase db) {
        int positionWithDiceThrow = getPosition() + diceThrow;
        try {
            setPosition(positionWithDiceThrow);
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
                        roundFinished = playTheRound(board[getPosition()], player);
                    } else {
                        int DiceThrowToGoBack = (int) (Math.random() * 6) + 1;
                        setPosition(Math.max(getPosition() - DiceThrowToGoBack, 0));
                        System.out.println("You went back to the space : " + getPosition());
                    }
                } else {
                    roundFinished = playTheRound(board[getPosition()], player);
                }
            }


        } catch (Exception e) {
            this.setPosition(64);
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
    }

    public boolean playTheRound(Cell cell, Hero player) {
        return cell.getRandomEvent().interactWithCell(player,cell);
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
