import character.enemies.Dragon;
import character.enemies.Goblin;
import character.enemies.Warlock;
import character.heros.Hero;
import equipement.potion.BigHealingPotion;
import equipement.potion.StandardHealingPotion;
import equipement.weapon.*;

import java.util.Arrays;

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
        for (int i = 0; i<64; i++){
            Cell test = new Cell();
            if (i <4) {
                test.setRandomEvent(new Dragon());
            } else if (i<14) {
                test.setRandomEvent(new Warlock());
            } else if (i<24) {
                test.setRandomEvent(new Goblin());
            } else if (i<29){
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
                test.setRandomEvent(new Stick());
            }
            board[i] = test;
        }
        ////////////SHUFFLE ARRAY
        int boardLength = board.length;
        for (int i = 0 ; i < boardLength ; i++) {
            int random = i + (int)(Math.random() * (boardLength - i));
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
    public void moveForward(int diceThrow, Hero player) {
        int positionWithDiceThrow = this.getPosition() + diceThrow;
        try {
            setPosition(positionWithDiceThrow);
            playTheRound(board[positionWithDiceThrow], player);
            System.out.println("You are now placed at space : " + positionWithDiceThrow);
        } catch (Exception e) {
            this.setPosition(64);
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

    public void playTheRound(Cell cell, Hero player) {
        cell.getRandomEvent().interactWithCell(player);
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
